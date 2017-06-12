package puj.co.mysql;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

        // Create the database tables if they don't exist
        createTables();
    }

    private static void createTables() {
        try {
            createCourseDefinitionTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * An utility for creating tables if only the table doesn't exists
     * @param tableName the table name
     * @param attributes    the attributes name
     * @param attributeTypes    the attribute types
     * @return  null if the attribute lengths dont match otherwise the string
     */
    private static String createTable(final String tableName, final String [] attributes, final String attributeTypes[]) {
        if (attributes.length != attributeTypes.length) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (");

        for (int i = 0; i < attributes.length; i ++) {
            builder.append(attributes[i]).append(" ").append(attributeTypes[i]).append(", ");
        }

        builder.append(")");
        return builder.toString();
    }

    /**
     * Attempts to create the course definition if its not already created
     */
    private static void createCourseDefinitionTable() throws SQLException {
        final String [] attributes = new String[] {
                "IDENTIFIER", "NAME", "INSTRUMENT", "GROUP"
        };
        final String [] attributeTypes = new String [] {
                "CHAR(9)", "VARCHAR(40)", "CHAR(1)", "CHAR(1)"
        };
        String tableCreation = createTable("COURSE", attributes, attributeTypes);
        final Connection connection = getConnection();
        final Statement statement = connection.createStatement();
        statement.executeUpdate(tableCreation);
        connection.close();
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
