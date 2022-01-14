package VideoLibrary;

import java.sql.*;

public class ChangeInfo {

    public boolean delete_old_films(Connection connection, Date date) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM films");
        int flag = 0;
        while (resultSet.next())
            if(resultSet.getDate("Date").before(date)) {
                resultSet.deleteRow();
                flag++;
            }
        if(flag != 0)
        return true;
        else
            return false;
    }

}
