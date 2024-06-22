/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplychain.system.dto.common;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jcruzm
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaGeneral {
    private String codigoRespuesta;
    private String mensajeRespuesta;
    private String codigoTransaccion;
    private String codigoPeticionUnica;
    private String tipoTransaccion;
    private String tipoProcesamiento;
    private String fechaRespuesta;
    private String horaRespuesta;
    
    private List<ParametroAdicionalItem> parametroAdicionalColeccion;
    private List<MensajeRespuestaItem> mensajeRespuestaColeccion;
    
    
}
