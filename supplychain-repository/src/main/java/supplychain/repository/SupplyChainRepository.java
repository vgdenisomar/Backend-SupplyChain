package supplychain.repository;

import supplychain.repository.config.SupplyChainConnectorDB;
import supplychain.repository.config.SupplyChainDBConfig;
import supplychain.repository.repository.PurchaseRepository;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class SupplyChainRepository {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SupplyChainDBConfig supplyChainDBConfig = SupplyChainDBConfig.getInstance(new SupplyChainConnectorDB("jdbc:sqlserver://localhost:1433;databaseName=SupplyChain", "sa", "admin@123", "com.microsoft.sqlserver.jdbc.SQLServerDriver"));
        
        PurchaseRepository purchaseRepository = new PurchaseRepository();
        
        System.out.println(purchaseRepository.findAll().toString());
    }
    
}
