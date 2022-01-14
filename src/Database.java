import java.sql.*;

public class Database {
    public static  void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Nastya228Tibo");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        PreparedStatement statement = con.prepareStatement("INSERT INTO ? VALUES (?), (?)");
        statement.setString(1, "test_table");
        statement.setString(2, "Odin");
        statement.setString(3, "Dva net Tor");
        statement.execute();
        ResultSet res = st.executeQuery("SELECT * FROM test.test_table");
        while (res.next())
            System.out.println(res.getString("String"));
    }
}
