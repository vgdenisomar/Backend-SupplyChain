package supplychain.repository.repository;

import supplychain.repository.config.SupplyChainDBConfig;
import supplychain.repository.entity.Purchase;
import supplychain.system.interfaces.BaseRepository;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class PurchaseRepository extends BaseRepository<Purchase, String> {

    public PurchaseRepository() {
        super(SupplyChainDBConfig.getInstance().getEntityManagerFactory(), Purchase.class);
    }
}
