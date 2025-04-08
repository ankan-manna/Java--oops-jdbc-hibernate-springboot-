import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        String sql = "select * from User";
        String url = "jdbc:postgresql://localhost:5432/chatapp";
        String username = "postgres";
        String password = "12345";

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
