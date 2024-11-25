package DbConfig;

import java.util.Arrays;

public class CrudManager {

    public static boolean create(String entity, String columns, Object... params) {
        try {
            String query = "INSERT INTO " + entity + " (" + columns + ") VALUES (" + getPlaceholders(params.length) + ")";
            int result = DbOperation.executeUpdate(query, params);
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Object[][] read(String query, Object... params) {
        try {
            Object result = DbOperation.executeQuery(query, params);
            if (result instanceof Object[][]) {
                return (Object[][]) result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Object[0][0];
    }

//    dynamic read function
//    public static Object[][] read(String table, String columns, String whereClause, Object... params) {
//        // Construct the SQL query
//        StringBuilder query = new StringBuilder("SELECT ")
//            .append(columns)
//            .append(" FROM ")
//            .append(table);
//
//        // Add WHERE clause if provided
//        if (whereClause != null && !whereClause.trim().isEmpty()) {
//            query.append(" WHERE ").append(whereClause);
//        }
//
//        // Convert StringBuilder to String
//        String sqlQuery = query.toString();
//
//        try {
//            // Execute the query
//            Object result = DbOperation.executeQuery(sqlQuery, params);
//
//            // Check if the result is of type Object[][]
//            if (result instanceof Object[][]) {
//                return (Object[][]) result;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Return an empty 2D array if an error occurs or no result
//        return new Object[0][0];
//    }
//}
   public static int update(String entity, String setClause, String whereClause, Object... params) {
    try {
        String query = "UPDATE " + entity + " SET " + setClause + " WHERE " + whereClause;
        System.out.println("Executing query: " + query);
        System.out.println("With parameters: " + Arrays.toString(params));
        int result = DbOperation.executeUpdate(query, params);
        return result;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}

    public static int delete(String entity, String whereClause, Object... params) {
        try {
            String query = "DELETE FROM " + entity + " WHERE " + whereClause;
            int result = DbOperation.executeUpdate(query, params);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean login(String email, String password) {
        try {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            Object[][] result = read(query, email, password);

            if (result.length > 0 && result[0].length > 0) {
                int count = ((Number) result[0][0]).intValue();
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String getPlaceholders(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("?");
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

