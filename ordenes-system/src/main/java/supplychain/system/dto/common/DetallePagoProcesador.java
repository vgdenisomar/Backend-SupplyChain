package supplychain.system.dto.common;

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
public class DetallePagoProcesador {

    private String codigo;
    private String descripcion;
    private String valor;
}
