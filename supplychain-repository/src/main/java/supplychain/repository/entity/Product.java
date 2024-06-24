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
@Table(name = "Product")
public class Product extends BaseEntity implements Serializable {

    @Column(name = "ProductCode", nullable = false)
    private String productCode;

    @Column(name = "ProductName", nullable = false)
    private String productName;

    @Column(name = "UnitOM", nullable = false)
    private String unitOM;

    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "ISV", nullable = false)
    private BigDecimal isv;

}
