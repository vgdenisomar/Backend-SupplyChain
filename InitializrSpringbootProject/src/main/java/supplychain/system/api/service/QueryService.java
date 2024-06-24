package supplychain.system.api.service;

import supplychain.domain.dto.createpurchase.CreatePurchaseDomain;
import supplychain.system.dto.response.SupplyChainResponse;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public interface QueryService {
    
    public SupplyChainResponse<CreatePurchaseDomain> getCreatePurchase();
}
