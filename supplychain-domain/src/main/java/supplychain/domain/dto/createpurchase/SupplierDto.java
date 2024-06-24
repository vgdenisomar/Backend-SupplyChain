package supplychain.domain.dto.createpurchase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {
    
    private String id;
    private String supplierName;
    private String supplierRTN;
    private String address;
    private String notes;
}
