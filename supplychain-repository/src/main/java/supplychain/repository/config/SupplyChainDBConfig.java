package supplychain.repository.config;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.annotation.PostConstruct;

/**
 *
 * @author dovelasquez
 */
public class SupplyChainDBConfig {

    private static final String PERSISTENCE_UNIT_NAME = "supplychain";
    private static SupplyChainDBConfig instance;
    private static EntityManagerFactory factory;

    private final SupplyChainConnectorDB connectorDB;

    public SupplyChainDBConfig(SupplyChainConnectorDB connectorDB) {
        this.connectorDB = connectorDB;
    }

    @PostConstruct
    public void init() {
        getEntityManagerFactory();
    }

    public static synchronized SupplyChainDBConfig getInstance(SupplyChainConnectorDB connectorDB) {
        if (instance == null && connectorDB != null) {
            instance = new SupplyChainDBConfig(connectorDB);
        } else if (instance == null) {
            throw new IllegalStateException("TransaccionDBConfig no ha sido inicializado con TransaccionConnectorDB.");
        }
        return instance;
    }

    public static synchronized SupplyChainDBConfig getInstance() {
        if (instance == null) {
            throw new IllegalStateException("TransaccionDBConfig no ha sido inicializado con TransaccionConnectorDB.");
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            synchronized (SupplyChainDBConfig.class) {
                Map<String, String> properties = new HashMap<>();
                properties.put("hibernate.connection.provider_class", "org.hibernate.hikaricp.internal.HikariCPConnectionProvider");
                properties.put("hibernate.hikari.driverClassName", connectorDB.getDriver());
                properties.put("hibernate.hikari.jdbcUrl", connectorDB.getHost());
                properties.put("hibernate.hikari.username", connectorDB.getUser());
                properties.put("hibernate.hikari.password", connectorDB.getPassword());
                properties.put("hibernate.hikari.maximumPoolSize", connectorDB.getMaxPoolSize().toString());
                properties.put("hibernate.hikari.minimumIdle", connectorDB.getMinPoolSize().toString());
                properties.put("hibernate.hikari.connectionTimeout", connectorDB.getTimeOut().toString());
                properties.put("hibernate.format_sql", "true");
                properties.put("hibernate.show_sql", "true");
                properties.put("hibernate.type", "trace");
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
            }

        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
