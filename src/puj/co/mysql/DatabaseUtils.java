package puj.co.mysql;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Sebastían on 12/06/2017.
 */
public class DatabaseUtils {

    /**
     * Constructs the mysql pool data sourcePool
     */
    private static final BasicDataSource sourcePool = new BasicDataSource();

    /**
     * Represents the database name
     */
    private static final String DATABASE_NAME = "ABET";

    /**
     * Represents the username of the database
     */
    private static final String USERNAME = "test";

    /**
     * Represents the password of the database
     */
    private static final String PASSWORD = "test";

    /**
     * This class doesn't needs to be instantiated
     */
    private DatabaseUtils() {
    }

    /**
     * Static initialization
     */
    static {
        sourcePool.setDriverClassName("com.mysql.jdbc.Driver");
        sourcePool.setUrl("jdbc:mysql://localhost:3306/" + DATABASE_NAME);
        sourcePool.setUsername(USERNAME);
        sourcePool.setPassword(PASSWORD);
    }

    /**
     * Attempts to retrieve an available connection from the pool
     * @return null if fails otherwise the connection
     */
    public static Connection getConnection() {
        try {
            return sourcePool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
