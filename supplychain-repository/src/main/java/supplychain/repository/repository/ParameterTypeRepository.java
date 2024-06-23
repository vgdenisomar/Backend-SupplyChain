package supplychain.repository.repository;

import supplychain.repository.config.SupplyChainDBConfig;
import supplychain.repository.entity.ParameterType;
import supplychain.system.interfaces.BaseRepository;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class ParameterTypeRepository extends BaseRepository<ParameterType, String> {

    public ParameterTypeRepository() {
        super(SupplyChainDBConfig.getInstance().getEntityManagerFactory(), ParameterType.class);
    }
}
