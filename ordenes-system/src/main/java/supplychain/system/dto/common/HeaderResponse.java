package supplychain.system.dto.common;

import lombok.Builder;
import lombok.Data;
/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Data
@Builder
public class HeaderResponse {
    private String code;
    private String message;
    private String technicalMessage;
    private String type;
}
