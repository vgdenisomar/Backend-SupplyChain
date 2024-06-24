package supplychain.system.api.dto;

import java.util.List;
import lombok.Data;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Data
public class RequestCreatePurchase {
    private String supplierIdUUID;
    private String purchaseDate;
    private String parameterDepartmentIdUUID;
    private String purchaseSubject;
    private String subtotal;
    private String exemptAmount;
    private String taxedAmount;
    private String isvAmount;
    private String total;
    private String letterValue;
    private String note;
    private String parameterPaymentMethodIdUUID;
    private List<DetailPurchase> detailPurchase;
}
