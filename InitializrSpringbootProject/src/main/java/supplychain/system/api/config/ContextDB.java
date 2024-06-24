package supplychain.system.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import supplychain.repository.config.SupplyChainConnectorDB;
import supplychain.repository.config.SupplyChainDBConfig;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@Configuration
public class ContextDB {

    @Bean
    public SupplyChainDBConfig supplyChainDBConfig() {
        return SupplyChainDBConfig.getInstance(new SupplyChainConnectorDB("jdbc:sqlserver://localhost:1433;databaseName=SupplyChain;encrypt=false;trustServerCertificate=true;", "sa", "admin@123", "com.microsoft.sqlserver.jdbc.SQLServerDriver"));
    }
}
