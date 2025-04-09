import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        String sql = "select * from User";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "12345";
        /*
 DriverManager class − used to load a SQL driver to connect to database.

Connection interface − used to make a connection to the database using database connection string and credentials.

Statement interface − used to make a query to the database.

PreparedStatement interface − used for a query with placeholder values.

CallableStatement interface − used to called stored procedure or functions in database.

ResultSet interface − represents the query results obtained from the database.

ResultSetMetaData interface − represents the metadata of the result set.
         */

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String name = rs.getString(1);
                System.out.println(name);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
