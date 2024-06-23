package supplychain.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import supplychain.system.interfaces.BaseEntity;

/**
 *
 * @author dovelasquez
 */
@DynamicUpdate
@Data
@Entity
@Table(name = "ParameterType")
@ToString(callSuper=true)
public class ParameterType extends BaseEntity implements Serializable {
    
    @Column(name = "ParameterTypeCode", nullable = false)
    private String parameterTypeCode;

    @Column(name = "ParameterTypeDescription", nullable = false)
    private String parameterTypeDescription;
    
    @OneToMany(mappedBy = "parameterType", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Parameter> parameters;
}
