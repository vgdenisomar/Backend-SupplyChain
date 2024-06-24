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
public class UnitMeasureDto {
    private String id;
    private String description;
}
