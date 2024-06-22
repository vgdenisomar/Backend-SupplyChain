package supplychain.system.dto.response;

import supplychain.system.dto.common.HeaderResponse;
import lombok.Data;

/**
 *
 * @author dovelasquez@bancatlan.hn
 * @param <T>
 */
@Data
public class RecaudosResponse<T> {

    private HeaderResponse header;
    private T body;
}
