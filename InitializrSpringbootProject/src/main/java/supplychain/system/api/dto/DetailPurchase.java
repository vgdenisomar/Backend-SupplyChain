package supplychain.system.api.dto;

import lombok.Data;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Data
public class DetailPurchase {

    private String item;
    private String unitOM;
    private String productIdUUID;
    private String quantity;
    private String unitPrice;
    private String subTotal;
    private String productName;
    private String isv;
}
