package supplychain.repository.config;

/**
 *
 * @author dovelasquez
 */
public class SupplyChainConnectorDB {

    private String host;
    private String user;
    private String password;
    private String driver;
    private Integer maxPoolSize = 10;
    private Integer minPoolSize = 5;
    private Integer timeOut = 30000;

    public SupplyChainConnectorDB(String host, String user, String password, String driver, Integer maxPoolSize, Integer minPoolSize, Integer timeOut) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.driver = driver;
        this.maxPoolSize = maxPoolSize;
        this.minPoolSize = minPoolSize;
        this.timeOut = timeOut;
    }

    public SupplyChainConnectorDB(String host, String user, String password, String driver) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public Integer getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(Integer minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

}
