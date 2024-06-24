package supplychain.command.stack.contract;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;
import supplychain.domain.dto.purchase.PurchaseDetailDto;
import supplychain.domain.dto.purchase.PurchaseDomain;
import supplychain.repository.config.SupplyChainDBConfig;
import supplychain.repository.entity.Product;
import supplychain.repository.entity.Purchase;
import supplychain.repository.entity.PurchaseDetail;
import supplychain.repository.repository.ProductRepository;
import supplychain.repository.repository.PurchaseRepository;
import supplychain.system.utils.GenericRepository;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Data
@Builder
public class PurchaseContract {

    private final PurchaseRepository purchaseRepository = new PurchaseRepository();
    private PurchaseDomain purchaseDomain;
    EntityManager entityManager;
    @Builder.Default
    private Purchase purchase = new Purchase();
    @Builder.Default
    private LocalDateTime fechaActual = LocalDateTime.now();
    private String purchaseNumber;

    public void save() {
        ModelMapper mapper = new ModelMapper();
        purchase = mapper.map(purchaseDomain, Purchase.class);
        purchase.setPurchaseNumber(generatePurchaseNumber());
        purchaseNumber = purchase.getPurchaseNumber();
        for (PurchaseDetail item : purchase.getPurchaseDetail()) {
            item.setPurchase(purchase);
            validateProduct(item);
        }
        Optional<Purchase> purchaseDB = purchaseRepository.findById(purchaseDomain.getId());
        GenericRepository.guardarCambios(entityManager, purchaseDB.isPresent() ? purchaseDB.get() : null, purchase);
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    private String generatePurchaseNumber() {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("SP_GET_PURCHASE_NUMBER");
        query.execute();
        String purchaseNumber = (String) query.getOutputParameterValue("purchaseNumber");
        return purchaseNumber;
    }

    private void validateProduct(PurchaseDetail purchaseDetail) {
        ProductRepository productRepository = new ProductRepository();

        Optional<Product> product = productRepository.findById(purchaseDetail.getProductIdUUID());

        if (product.isEmpty()) {
            Product newProduct = new Product();
            newProduct.setId(purchaseDetail.getProductIdUUID());
            newProduct.setProductCode("1");
            newProduct.setProductName(purchaseDetail.getProductName());
            newProduct.setUnitPrice(purchaseDetail.getUnitPrice());
            newProduct.setUnitOM(purchaseDetail.getUnitOM());
            newProduct.setIsv(purchaseDetail.getIsv());
            newProduct.setDateCreated(purchaseDetail.getDateCreated());
            newProduct.setUserCreated(purchaseDetail.getUserCreated());
            newProduct.setUserLastModify(purchaseDetail.getUserLastModify());
            newProduct.setDateLastModify(purchaseDetail.getDateLastModify());
            newProduct.setRegistryStatus("ACTIVO");
            entityManager.persist(newProduct);
        }
    }

}
