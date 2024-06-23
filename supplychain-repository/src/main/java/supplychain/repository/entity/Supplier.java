package supplychain.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import supplychain.system.interfaces.BaseEntity;

/**
 *
 * @author dovelasquez
 */
@DynamicUpdate
@Data
@Entity
@Table(name = "Supplier")
public class Supplier extends BaseEntity implements Serializable {

    @Column(name = "SupplierName", nullable = false)
    private String supplierName;

    @Column(name = "SupplierRTN", nullable = false)
    private String supplierRTN;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Notes", nullable = false)
    private String notes;

}
