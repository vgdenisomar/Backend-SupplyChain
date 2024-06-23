package supplychain.repository.repository;

import supplychain.repository.config.SupplyChainDBConfig;
import supplychain.repository.entity.Product;
import supplychain.system.interfaces.BaseRepository;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class ProductRepository extends BaseRepository<Product, String> {

    public ProductRepository() {
        super(SupplyChainDBConfig.getInstance().getEntityManagerFactory(), Product.class);
    }
}
