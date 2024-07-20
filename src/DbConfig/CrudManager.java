package DbConfig;

public class CrudManager {
    
    public static int create(String entity, String columns, Object ...params) {
        try {
            String query = "INSERT INTO " + entity + " (" + columns + ") VALUES (" + getPlaceholders(params.length) + ")";
            Object result = DbOperation.executeQuery(query, params);
            if (result instanceof Integer) {
                return (Integer) result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Object[][] read(String query, Object ...params) {
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

    public static int update(String entity, String setClause, String whereClause, Object ...params) {
        try {
            String query = "UPDATE " + entity + " SET " + setClause + " WHERE " + whereClause;
            Object result = DbOperation.executeQuery(query, params);
            if (result instanceof Integer) {
                return (Integer) result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int delete(String entity, String whereClause, Object ...params) {
        try {
            String query = "DELETE FROM " + entity + " WHERE " + whereClause;
            Object result = DbOperation.executeQuery(query, params);
            if (result instanceof Integer) {
                return (Integer) result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static String getPlaceholders(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("?");
            if (i < length - 1) sb.append(", ");
        }
        return sb.toString();
    }
}
