package main;

/**
 * Created by ${Zhenya} on 015 15.06.18.
 */
public class DBCredentials {
    private final String dbURL;
    private final String username;
    private final String password;

    public DBCredentials(String dbURL, String username, String password) {
        this.dbURL = dbURL;
        this.username = username;
        this.password = password;
    }

    public String getDbURL() {
        return dbURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
