import java.sql.*;

public class Demo {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/android_test";

    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
//            com.mysql.jdbc.Driver l;
            System.out.println("Connecting to the Database");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating Statement");
            statement = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user_data";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int serial_no = rs.getInt("serial no");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int age = rs.getInt("age");

                System.out.println("SL: " + serial_no +
                        ", Name: " + username + ", Pass: " + password + ", Age: " + age);
            }

            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }


    }
}
