import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static  void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Nastya228Tibo");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet res = st.executeQuery("SELECT * FROM test.aboba");
        res.moveToInsertRow();
        res.updateInt("aboba_pk", 2);
        res.updateInt("weight", 22);
        res.updateString("name", "Iuuuu");
        res.insertRow();
        res.moveToCurrentRow();
        List<String> aaa = new ArrayList<>();
        while (res.next()) {
            aaa.add(res.getInt("weight") + " " + res.getString("name"));
        }
        System.out.println(aaa);
    }
}
