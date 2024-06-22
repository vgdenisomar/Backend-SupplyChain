/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplychain.system.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dovelasquez
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParametroAdicionalItem {
    private Integer numeroLinea;
    private String descripcionValor;
    private String valor;
}
