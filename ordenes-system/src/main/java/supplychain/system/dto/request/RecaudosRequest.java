package supplychain.system.dto.request;

import supplychain.system.dto.common.HeaderRequest;
import lombok.Data;

/**
 *
 * @author dovelasquez@bancatlan.hn
 * @param <T>
 */
@Data
public class RecaudosRequest<T> {
    
    private HeaderRequest header;
    private T body;
    
    
}
