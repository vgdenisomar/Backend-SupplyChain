package supplychain.system.api.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import supplychain.command.stack.SupplyChainCommandStack;
import supplychain.domain.dto.purchase.PurchaseDetailDto;
import supplychain.domain.dto.purchase.PurchaseDomain;
import supplychain.system.api.dto.RequestCreatePurchase;
import supplychain.system.dto.common.HeaderResponse;
import supplychain.system.dto.request.SupplyChainRequest;
import supplychain.system.dto.response.SupplyChainResponse;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Service
public class CommandStackImpl implements CommandStack {

    @Override
    public SupplyChainResponse<String> createPurchase(SupplyChainRequest<RequestCreatePurchase> requestCreatePurchase) {
        SupplyChainCommandStack supplyChainCommandStack = new SupplyChainCommandStack();

        String purchaseNumber = supplyChainCommandStack.savePurchase(this.mapPurchaseDomain(requestCreatePurchase));

        return (SupplyChainResponse.<String>builder()
                .body(purchaseNumber)
                .header(HeaderResponse.builder()
                        .code("0000")
                        .message("Transaccion exitosa")
                        .build())
                .build());
    }

    private PurchaseDomain mapPurchaseDomain(SupplyChainRequest<RequestCreatePurchase> requestCreatePurchase) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime currentDate = LocalDateTime.now();
        
        List<PurchaseDetailDto> purchaseDetail = new ArrayList<>();
        
        requestCreatePurchase.getBody().getDetailPurchase().forEach(item -> {
            purchaseDetail.add(PurchaseDetailDto.builder()
                        .id(UUID.randomUUID().toString())
                        .unitOM(item.getUnitOM())
                        .item(1)
                        .productIdUUID(item.getProductIdUUID().isEmpty() ? UUID.randomUUID().toString() : item.getProductIdUUID() )
                        .quantity(new BigDecimal(item.getQuantity()))
                        .unitPrice(new BigDecimal(item.getUnitPrice()))
                        .subTotal(new BigDecimal(item.getSubTotal()))
                        .userCreated(requestCreatePurchase.getHeader().getUser())
                        .dateCreated(currentDate)
                        .userLastModify(requestCreatePurchase.getHeader().getUser())
                        .dateLastModify(currentDate)
                        .registryStatus("ACTIVO")
                        .isv(new BigDecimal(item.getIsv()))
                        .productName(item.getProductName())
                        .build());
        });
        
        PurchaseDomain purchaseDomain = PurchaseDomain.builder()
                .id(UUID.randomUUID().toString())
                .supplierIdUUID(requestCreatePurchase.getBody().getSupplierIdUUID())
                .purchaseDate(LocalDate.parse(requestCreatePurchase.getBody().getPurchaseDate(),formatter))
                .parameterDepartmentIdUUID(requestCreatePurchase.getBody().getParameterDepartmentIdUUID())
                .purchaseSubject(requestCreatePurchase.getBody().getPurchaseSubject())
                .subtotal(new BigDecimal(requestCreatePurchase.getBody().getSubtotal()))
                .exemptAmount(new BigDecimal(requestCreatePurchase.getBody().getExemptAmount()))
                .taxedAmount(new BigDecimal(requestCreatePurchase.getBody().getTaxedAmount()))
                .isvAmount(new BigDecimal(requestCreatePurchase.getBody().getIsvAmount()))
                .total(new BigDecimal(requestCreatePurchase.getBody().getTotal()))
                .letterValue("CERO")
                .note(requestCreatePurchase.getBody().getNote())
                .parameterPaymentMethodIdUUID(requestCreatePurchase.getBody().getParameterPaymentMethodIdUUID())
                .userCreated(requestCreatePurchase.getHeader().getUser())
                .dateCreated(currentDate)
                .userLastModify(requestCreatePurchase.getHeader().getUser())
                .dateLastModify(currentDate)
                .registryStatus("ACTIVO")
                .purchaseDetail(purchaseDetail)
                .build();

        return purchaseDomain;
    }

}
