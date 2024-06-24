package supplychain.system.api.service;

import supplychain.system.api.dto.RequestCreatePurchase;
import supplychain.system.dto.request.SupplyChainRequest;
import supplychain.system.dto.response.SupplyChainResponse;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public interface CommandStack {
    public SupplyChainResponse<String> createPurchase(SupplyChainRequest<RequestCreatePurchase> requestCreatePurchase);
}
