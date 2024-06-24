package supplychain.domain.dto.purchase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Data
@Builder
public class PurchaseDomain {

    private String id;
    private String purchaseNumber;
    private String supplierIdUUID;
    private LocalDate purchaseDate;
    private String parameterDepartmentIdUUID;
    private String purchaseSubject;
    private BigDecimal subtotal;
    private BigDecimal exemptAmount;
    private BigDecimal taxedAmount;
    private BigDecimal isvAmount;
    private BigDecimal total;
    private String letterValue;
    private String note;
    private String parameterPaymentMethodIdUUID;
    private String userCreated;
    private LocalDateTime dateCreated;
    private String userLastModify;
    private LocalDateTime dateLastModify;
    private String registryStatus;
    @Singular("addPurchaseDetail")
    private List<PurchaseDetailDto> purchaseDetail;
}
