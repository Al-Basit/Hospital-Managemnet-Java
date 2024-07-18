package DBOperations;

import config.GlobalConstants;
import java.sql.*;

public class dbSetup {
    public static Connection getConnet() throws SQLException{
        Connection con = null;
        try{
            Class.forName("com.mysql.cs.jdbc.Driver");
            con = DriverManager.getConnection(GlobalConstants.DB_URL, GlobalConstants.DB_USER, GlobalConstants.DB_PASSWORD);
        }catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Error connecting to the database");
        }
        return con;
    }
}
