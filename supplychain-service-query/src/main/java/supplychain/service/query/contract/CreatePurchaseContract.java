package supplychain.service.query.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;
import supplychain.domain.dto.createpurchase.CreatePurchaseDomain;
import supplychain.domain.dto.createpurchase.DepartmentDto;
import supplychain.domain.dto.createpurchase.PaymentMethodDto;
import supplychain.domain.dto.createpurchase.PositionDto;
import supplychain.domain.dto.createpurchase.ProductDto;
import supplychain.domain.dto.createpurchase.SupplierDto;
import supplychain.domain.dto.createpurchase.UnitMeasureDto;
import supplychain.repository.entity.ParameterType;
import supplychain.repository.entity.Product;
import supplychain.repository.entity.Supplier;
import supplychain.repository.repository.ParameterTypeRepository;
import supplychain.repository.repository.ProductRepository;
import supplychain.repository.repository.SupplierRepository;
import supplychain.system.utils.constant.ParameterTypeConstant;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class CreatePurchaseContract {

    private final ModelMapper modelMapper = new ModelMapper();
    private List<ParameterType> parameterTypes = new ArrayList<>();

    public CreatePurchaseDomain getCreatePurchaseDomain() {
        getParametersType();
        return CreatePurchaseDomain.builder()
                .products(getProducts())
                .suppliers(getSuppliers())
                .departments(getDepartments())
                .paymentMethods(getPaymentMethods())
                .positions(getPositions())
                .unitMeasures(getUnitMeasure())
                .build();
    }

    private List<ProductDto> getProducts() {
        ProductRepository productRepository = new ProductRepository();

        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(item -> {
            productDtos.add(modelMapper.map(item, ProductDto.class));
        });
        return productDtos;
    }

    private List<SupplierDto> getSuppliers() {
        SupplierRepository supplierRepository = new SupplierRepository();

        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDto> supplierDtos = new ArrayList<>();
        suppliers.forEach(item -> {
            supplierDtos.add(modelMapper.map(item, SupplierDto.class));
        });
        return supplierDtos;
    }

    private void getParametersType() {
        ParameterTypeRepository parameterTypeRepository = new ParameterTypeRepository();
        parameterTypes = parameterTypeRepository.findAll();
    }

    private List<DepartmentDto> getDepartments() {
        return parameterTypes.stream()
                .filter(pt -> ParameterTypeConstant.DEPARTMENT.equalsIgnoreCase(pt.getParameterTypeCode())) // Filtrar por el campo type
                .flatMap(pt -> pt.getParameters().stream()) // Obtener los elementos del campo parameters
                .map(parameter -> modelMapper.map(parameter, DepartmentDto.class)) // Mapear a MappedObject
                .collect(Collectors.toList());
    }

    private List<PaymentMethodDto> getPaymentMethods() {
        return parameterTypes.stream()
                .filter(pt -> ParameterTypeConstant.PAYMENT_METHOD.equalsIgnoreCase(pt.getParameterTypeCode())) // Filtrar por el campo type
                .flatMap(pt -> pt.getParameters().stream()) // Obtener los elementos del campo parameters
                .map(parameter -> modelMapper.map(parameter, PaymentMethodDto.class)) // Mapear a MappedObject
                .collect(Collectors.toList());
    }

    private List<UnitMeasureDto> getUnitMeasure() {
        return parameterTypes.stream()
                .filter(pt -> ParameterTypeConstant.UNIT_MEASURE.equalsIgnoreCase(pt.getParameterTypeCode())) // Filtrar por el campo type
                .flatMap(pt -> pt.getParameters().stream()) // Obtener los elementos del campo parameters
                .map(parameter -> modelMapper.map(parameter, UnitMeasureDto.class)) // Mapear a MappedObject
                .collect(Collectors.toList());
    }

    private List<PositionDto> getPositions() {
        return parameterTypes.stream()
                .filter(pt -> ParameterTypeConstant.POSITION.equalsIgnoreCase(pt.getParameterTypeCode())) // Filtrar por el campo type
                .flatMap(pt -> pt.getParameters().stream()) // Obtener los elementos del campo parameters
                .map(parameter -> modelMapper.map(parameter, PositionDto.class)) // Mapear a MappedObject
                .collect(Collectors.toList());
    }
}
