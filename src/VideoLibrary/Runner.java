package VideoLibrary;

import java.sql.Date;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new ChangeInfo().delete_old_films(new ConnectDB().connect("jdbc:mysql://localhost:3306/videolibrary", "root", "Nastya228Tibo"), new Date(2014 - 1900, 10, 10));
    }
}
