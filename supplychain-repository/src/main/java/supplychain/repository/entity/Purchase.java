package supplychain.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
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
@Table(name = "Purchase")
@ToString(callSuper=true)
public class Purchase extends BaseEntity implements Serializable {

    @Column(name = "PurchaseNumber", nullable = false)
    private String purchaseNumber;

    @Column(name = "Supplier_ID_UUID", nullable = false)
    private String supplierIdUUID;

    @Column(name = "PurchaseDate", nullable = false)
    private LocalDate purchaseDate;

    @Column(name = "ParameterDepartment_ID_UUID", nullable = false)
    private String parameterDepartmentIdUUID;

    @Column(name = "PurchaseSubject", nullable = false)
    private String purchaseSubject;

    @Column(name = "Subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "ExemptAmount", nullable = false)
    private BigDecimal exemptAmount;

    @Column(name = "TaxedAmount", nullable = false)
    private BigDecimal taxedAmount;

    @Column(name = "ISVAmount", nullable = false)
    private BigDecimal isvAmount;

    @Column(name = "Total", nullable = false)
    private BigDecimal total;

    @Column(name = "LetterValue", nullable = false)
    private String letterValue;

    @Column(name = "Note")
    private String note;

    @Column(name = "ParameterPaymentMethod_ID_UUID", nullable = false)
    private String parameterPaymentMethodIdUUID;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PurchaseDetail> purchaseDetail;
}
