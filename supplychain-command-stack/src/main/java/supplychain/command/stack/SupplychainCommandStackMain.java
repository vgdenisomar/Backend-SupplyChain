package supplychain.command.stack;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import supplychain.domain.dto.PurchaseDetailDto;
import supplychain.domain.dto.PurchaseDomain;
import supplychain.repository.config.SupplyChainConnectorDB;
import supplychain.repository.config.SupplyChainDBConfig;
import supplychain.repository.entity.PurchaseDetail;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class SupplychainCommandStackMain {

    public static void main(String[] args) {
        SupplyChainDBConfig supplyChainDBConfig = SupplyChainDBConfig.getInstance(new SupplyChainConnectorDB("jdbc:sqlserver://localhost:1433;databaseName=SupplyChain", "sa", "admin@123", "com.microsoft.sqlserver.jdbc.SQLServerDriver"));

        SupplyChainCommandStack s = new SupplyChainCommandStack();
        PurchaseDomain purchaseDomain = PurchaseDomain.builder()
                .id(UUID.randomUUID().toString())
                .purchaseNumber("9999-2024 ")
                .supplierIdUUID("10c00b66-f58f-42b3-914f-a7a211c35206")
                .purchaseDate(LocalDate.now())
                .parameterDepartmentIdUUID("8600121e-b9c0-47d2-a48d-76e89c5e1779")
                .purchaseSubject("SUMINISTRO DE VIVERES")
                .subtotal(BigDecimal.ZERO)
                .exemptAmount(BigDecimal.ZERO)
                .taxedAmount(BigDecimal.TEN)
                .isvAmount(BigDecimal.ONE)
                .total(BigDecimal.ONE)
                .letterValue("CERO")
                .note("")
                .parameterPaymentMethodIdUUID("d82ab4a2-3266-4d84-a800-0eaea72df2fc")
                .userCreated("denis")
                .dateCreated(LocalDateTime.now())
                .userLastModify("denis")
                .dateLastModify(LocalDateTime.now())
                .registryStatus("INACTIVO")
                .addPurchaseDetail(PurchaseDetailDto.builder()
                        .id(UUID.randomUUID().toString())
                        .unitOM("1")
                        .item(1)
                        .productIdUUID("76585bd4-b749-43f3-b71e-7a8735ab49f9")
                        .quantity(BigDecimal.ONE)
                        .unitPrice(BigDecimal.ONE)
                        .subTotal(BigDecimal.ZERO)
                        .userCreated("denis")
                        .dateCreated(LocalDateTime.now())
                        .userLastModify("denis")
                        .dateLastModify(LocalDateTime.now())
                        .registryStatus("INACTIVO")
                        .build())
                .addPurchaseDetail(PurchaseDetailDto.builder()
                        .id(UUID.randomUUID().toString())
                        .unitOM("1")
                        .item(1)
                        .productIdUUID("76585bd4-b749-43f3-b71e-7a8735ab49f9")
                        .quantity(BigDecimal.ONE)
                        .unitPrice(BigDecimal.ONE)
                        .subTotal(BigDecimal.ZERO)
                        .userCreated("denis")
                        .dateCreated(LocalDateTime.now())
                        .userLastModify("denis")
                        .dateLastModify(LocalDateTime.now())
                        .registryStatus("INACTIVO")
                        .build())
                .build();
        s.savePurchase(purchaseDomain);
    }
}
