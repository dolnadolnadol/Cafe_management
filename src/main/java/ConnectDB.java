import java.sql.*;

public class ConnectDB {

    private final String HOST = "localhost";
    private final int PORT = 3306;
    private final String DATABASE = "cafe";
    private final String USERNAME = "Cafe_admin";
    private final String PASSWORD = "Cafe_admin";
    private Connection connection;

    public void connect() throws SQLException {
//        String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useUnicode=true&characterEncoding=UTF-8";
//        System.out.println(url);
        connection = DriverManager.getConnection(
                "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useUnicode=true&characterEncoding=UTF-8", USERNAME , PASSWORD
        );
    }
    public void connect_src() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useUnicode=true&amp;characterEncoding=UTF-8", USERNAME, PASSWORD
        );
    }
    public boolean isConnected() {
        return connection != null;
    }
    public boolean isConnected_src() {
        return connection != null;
    }

    public Connection getConnection() {
        return connection;
    }
    public Connection getConnection_src() {
        return connection;
    }
    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void disconnect_src() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            ConnectDB mysql = new ConnectDB();
            mysql.connect();
            PreparedStatement statement = mysql.getConnection().prepareStatement("SELECT * FROM beverage");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.printf (String.format("%-3s %-25s %s%n", rs.getString("B_id"), rs.getString("B_name"), rs.getString("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
