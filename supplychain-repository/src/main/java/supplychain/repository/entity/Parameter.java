package supplychain.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Parameter")
@ToString(exclude = "parameterType")
public class Parameter extends BaseEntity implements Serializable {

    @Column(name = "ParameterDescription", nullable = false)
    private String parameterDescription;

    @ManyToOne
    @JoinColumn(name = "ParameterType_ID_UUID")
    @JsonBackReference
    private ParameterType parameterType;

}
