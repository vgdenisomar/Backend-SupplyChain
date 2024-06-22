package supplychain.system.dto.common;

import java.util.List;
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
public class PeticionGeneral {

    private String servicioId;
    private String aplicacionId;
    private String canalId;
    private String paisId;
    private String institucionId;
    private String regionId;
    private String motorId;
    private String idioma;
    private String version;
    private String llaveSesion;
    private String usuarioId;
    private String clienteCoreId;
    private String dispositivoId;
    private String ambiente;
    private String mandante;
    private String codigoPeticionUnica;
    private String codigoCore;
    private String codigoAgencia;
    private String codigoSucursal;
    private String usuarioAplicacion;
    private String direccionIp;
    private String tipoProcesamiento;
    private String tipoTransaccion;
    private List<ParametroAdicionalItem> parametroAdicionalColeccion;
}
