package supplychain.repository;

import supplychain.repository.config.SupplyChainConnectorDB;
import supplychain.repository.config.SupplyChainDBConfig;
import supplychain.repository.repository.ProductRepository;
import supplychain.repository.repository.SupplierRepository;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class SupplyChainRepository {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SupplyChainDBConfig supplyChainDBConfig = SupplyChainDBConfig.getInstance(new SupplyChainConnectorDB("jdbc:sqlserver://localhost:1433;databaseName=SupplyChain", "sa", "123", "com.microsoft.sqlserver.jdbc.SQLServerDriver"));
        
        ProductRepository r = new ProductRepository();
        
        System.out.println(r.findAll().toString());
    }
    
}
