package supplychain.domain.dto.purchase;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Data
@Builder
public class PurchaseDetailDto {

    private String id;
    private Integer item;
    private String unitOM;
    private String productIdUUID;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal subTotal;
    private String userCreated;
    private LocalDateTime dateCreated;
    private String userLastModify;
    private LocalDateTime dateLastModify;
    private String registryStatus;

    private String productName;
    private BigDecimal isv;
}
