package supplychain.system.api.service;

import org.springframework.stereotype.Service;
import supplychain.domain.dto.createpurchase.CreatePurchaseDomain;
import supplychain.service.query.ISupplyChainServiceQuery;
import supplychain.service.query.SupplyChainServiceQueryImpl;
import supplychain.system.dto.common.HeaderResponse;
import supplychain.system.dto.response.SupplyChainResponse;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Service
public class QueryServiceImpl implements QueryService{

    @Override
    public SupplyChainResponse<CreatePurchaseDomain> getCreatePurchase() {
        ISupplyChainServiceQuery supplyChainServiceQuery = new SupplyChainServiceQueryImpl();
        
        CreatePurchaseDomain createPurchaseDomain = supplyChainServiceQuery.getDomainCreatePurchase();
        return (SupplyChainResponse.<CreatePurchaseDomain>builder()
                .body(createPurchaseDomain)
                .header(HeaderResponse.builder()
                .code("0000")
                .message("Transaccion exitosa")
                .build())
                .build());
    }
    
}
