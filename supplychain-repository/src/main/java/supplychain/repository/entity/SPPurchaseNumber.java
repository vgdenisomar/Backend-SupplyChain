package supplychain.repository.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Entity
@NamedStoredProcedureQuery(
    name = "SP_GET_PURCHASE_NUMBER",
    procedureName = "SP_GET_PURCHASE_NUMBER",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "purchaseNumber", type = String.class)
    }
)
public class SPPurchaseNumber implements Serializable{
    
    @Id
    private String value;
    
}
