package supplychain.domain.dto.createpurchase;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Data
@Builder
public class CreatePurchaseDomain {

    private List<SupplierDto> suppliers;
    private List<DepartmentDto> departments;
    private List<ProductDto> products;
    private List<UnitMeasureDto> unitMeasures;
    private List<PaymentMethodDto> paymentMethods;
    private List<PositionDto> positions;
}
