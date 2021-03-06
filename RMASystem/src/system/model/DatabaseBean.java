
package system.model;

public class DatabaseBean {
    private String port, host;
    private String databaseName;
    private String username;
    private String password;

    public DatabaseBean(String port, String host, String databaseName, String username, String password) {
        this.port = port;
        this.host = host;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }
    
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
