package supplychain.system.dto.request.procesador;

import supplychain.system.dto.common.PeticionGeneral;
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
public class ProcesadorRequest<T> {

    PeticionGeneral peticionGeneral;
    T peticionEspecifica;
}
