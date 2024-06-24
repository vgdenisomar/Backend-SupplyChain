package supplychain.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import supplychain.system.interfaces.BaseEntity;

/**
 *
 * @author dovelasquez
 */
@Data
@DynamicUpdate
@ToString(exclude = "purchase")
@Entity
@Table(name = "PurchaseDetail")
public class PurchaseDetail extends BaseEntity implements Serializable {

    @Column(name = "Item", nullable = false)
    private Integer item;

    @ManyToOne
    @JoinColumn(name = "Purchase_ID_UUID")
    @JsonBackReference
    private Purchase purchase;

    @Column(name = "UnitOM", nullable = false)
    private String unitOM;

    @Column(name = "Product_ID_UUID", nullable = false)
    private String productIdUUID;

    @Column(name = "Quantity", nullable = false)
    private BigDecimal quantity;

    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "SubTotal", nullable = false)
    private BigDecimal subTotal;
    
    @Transient
    private String productName;
    
    @Transient
    private BigDecimal isv;
    
}
