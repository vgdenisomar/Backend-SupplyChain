package supplychain.repository.repository;

import supplychain.repository.config.SupplyChainDBConfig;
import supplychain.repository.entity.Supplier;
import supplychain.system.interfaces.BaseRepository;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class SupplierRepository extends BaseRepository<Supplier, String> {

    public SupplierRepository() {
        super(SupplyChainDBConfig.getInstance().getEntityManagerFactory(), Supplier.class);
    }
}
