package supplychain.service.query;

import supplychain.domain.dto.createpurchase.CreatePurchaseDomain;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public interface ISupplyChainServiceQuery {
    
    public CreatePurchaseDomain getDomainCreatePurchase();
}
