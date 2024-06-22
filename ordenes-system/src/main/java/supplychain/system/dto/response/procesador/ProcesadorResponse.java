package supplychain.system.dto.response.procesador;

import supplychain.system.dto.common.RespuestaGeneral;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dovelasquez@bancatlan.hn
 * @param <T>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcesadorResponse <T>{
    RespuestaGeneral respuestaGeneral;
    T respuestaEspecifica;
}
