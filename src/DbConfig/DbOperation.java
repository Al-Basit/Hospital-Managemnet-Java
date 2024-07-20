package DbConfig;

import java.sql.*;

public class DbOperation {

    public static Object executeQuery(String query, Object... params) throws SQLException {
        Object result = null;
        Connection con = null;
        PreparedStatement pdst = null;
        ResultSet rs = null;

        try {
            con = DbSetup.getConnection();
            pdst = con.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                pdst.setObject(i + 1, params[i]);
            }

            boolean hasResult = pdst.execute();

            if (hasResult) {
                rs = pdst.executeQuery();
                
                rs.last();
                int rowCount = rs.getRow();
                System.out.println("Number of rows: " + rowCount);
                
                rs.beforeFirst();
                
                int columnCount = rs.getMetaData().getColumnCount();
                Object[][] table = new Object[rowCount][columnCount];
                
                int currentRow = 0;
                while (rs.next()) {
                    for (int i = 0; i < columnCount; i++) {
                        table[currentRow][i] = rs.getObject(i + 1);
                    }
                    currentRow++;
                }
                result = table;
            } else {
                int updateCount = pdst.getUpdateCount();
                result = updateCount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error executing query", e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (pdst != null) try { pdst.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (con != null) DbSetup.closeConnection(con);
        }

        return result;
    }
}
