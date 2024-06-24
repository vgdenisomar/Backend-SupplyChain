package supplychain.system.dto.response;

import lombok.Builder;
import supplychain.system.dto.common.HeaderResponse;
import lombok.Data;

/**
 *
 * @author dovelasquez@bancatlan.hn
 * @param <T>
 */
@Data
@Builder
public class SupplyChainResponse<T> {

    private HeaderResponse header;
    private T body;
}
