package supplychain.system.dto.common;

import lombok.Data;
/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Data
public class HeaderRequest {
    private String code;
    private String message;
    private String technicalMessage;
    private String type;
    private String serviceId;
    private String sessionId;
    private String transactionDateTime;
    private String user;
    private String channelId;
}
