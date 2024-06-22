package supplychain.command.stack.contract;

import java.time.LocalDateTime;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;
import supplychain.domain.dto.PurchaseDetailDto;
import supplychain.domain.dto.PurchaseDomain;
import supplychain.repository.entity.Purchase;
import supplychain.repository.entity.PurchaseDetail;
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

    public void save() {
        ModelMapper mapper = new ModelMapper();
        purchase = mapper.map(purchaseDomain, Purchase.class);
        
        for (PurchaseDetail item : purchase.getPurchaseDetail()) {
            item.setPurchase(purchase);
        }
        System.out.println(purchase);
        Optional<Purchase> purchaseDB = purchaseRepository.findById(purchaseDomain.getId());
        GenericRepository.guardarCambios(entityManager, purchaseDB.isPresent()?purchaseDB.get():null, purchase);
    }

}
