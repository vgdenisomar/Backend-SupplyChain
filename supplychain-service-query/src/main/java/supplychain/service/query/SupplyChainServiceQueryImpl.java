package supplychain.service.query;

import supplychain.domain.dto.createpurchase.CreatePurchaseDomain;
import supplychain.service.query.contract.CreatePurchaseContract;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class SupplyChainServiceQueryImpl implements ISupplyChainServiceQuery{

    @Override
    public CreatePurchaseDomain getDomainCreatePurchase() {
        CreatePurchaseContract createPurchaseContract = new CreatePurchaseContract();
        return createPurchaseContract.getCreatePurchaseDomain();
    }
    
}
