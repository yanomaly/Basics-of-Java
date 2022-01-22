package Database.VideoLibrary;

import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TakeInfo {
    public void films_this_and_previous_years(Connection connection, int years) throws SQLException {
        String sql = "SELECT * FROM videolibrary.films WHERE YEAR(Date) > YEAR(CURRENT_DATE()) - ?";
        String sql1 = "SELECT * FROM actors WHERE ID = ?";
        String sql2 = "SELECT * FROM producers WHERE ID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        PreparedStatement statementA = connection.prepareStatement(sql1);
        PreparedStatement statementP = connection.prepareStatement(sql2);
        statement.setInt(1, years);

        ResultSet resultset = statement.executeQuery();

        Map<String, Film> result = new HashMap<>();

        while(resultset.next()) {
            statementP.setInt(1, resultset.getInt("ProducerID"));
            ResultSet rsP = statementP.executeQuery();
            rsP.next();
            String prod = rsP.getString("Name") + " " + rsP.getString("Surname");
            statementA.setInt(1, resultset.getInt("ActorID"));
            ResultSet rsA = statementA.executeQuery();
            rsA.next();
            if(result.keySet().contains(resultset.getString("Name")))
                result.put(resultset.getString("Name"), new Film(resultset.getString("Name"), resultset.getString("Country"), resultset.getDate("Date"), result.get(resultset.getString("Name")).getActors() + ", " + rsA.getString("Name") + " " +  rsA.getString("Surname"), prod));
            else
                result.put(resultset.getString("Name"), new Film(resultset.getString("Name"), resultset.getString("Country"), resultset.getDate("Date"),rsA.getString("Name") + " " +  rsA.getString("Surname"), prod));
        }
        for (Film temp:
             result.values()) {
            System.out.println(temp + "\n");
        }
    }

    public void actors_from_film(Connection connection, String film) throws SQLException {
        String sql = "SELECT ActorID FROM films WHERE Name = ?";
        String sql1 = "SELECT Name, Surname FROM actors WHERE ID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        PreparedStatement statement1 = connection.prepareStatement(sql1);
        statement.setString(1, film);
        ResultSet resultSet = statement.executeQuery(), resultSet1;
        String result = "Actors of " + film + ":\n";
        while (resultSet.next()){
            statement1.setInt(1, resultSet.getInt("ActorID"));
            resultSet1 = statement1.executeQuery();
            resultSet1.next();
            result += resultSet1.getString("Name") + " " + resultSet1.getString("Surname") + "\n";
        }
        System.out.println(result);
    }

    public void actors_from_N_films(Connection connection, Integer N) throws SQLException {
        Statement statement = connection.createStatement();
        Statement statement1 = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM actors");
        ResultSet resultSet1 = statement1.executeQuery("SELECT ActorID FROM films");
        ArrayList<Integer> ID = new ArrayList<>();
        String result = "Actor with " + N + " plays:\n";
        while (resultSet1.next())
            ID.add(resultSet1.getInt(1));
        ID.remove(Integer.valueOf(0));
        while (resultSet.next()){
            int temp = resultSet.getInt("ID"), count = 0;
            while (ID.contains(temp)){
                count++;
                ID.remove(Integer.valueOf(temp));
            }
            if(count == N.intValue())
                result += resultSet.getString("Name") + " " + resultSet.getString("Surname") + "\n";
        }
        System.out.println(result);
    }

    public void producers_at_least_one_film(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Statement statement1 = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM producers");
        ResultSet resultSet1 = statement1.executeQuery("SELECT ProducerID FROM films");
        ArrayList<Integer> ID = new ArrayList<>();
        String result = "Producers with at least one film:\n";
        while (resultSet1.next())
            ID.add(resultSet1.getInt(1));
        while (resultSet.next())
            if(ID.contains(resultSet.getInt("ID")))
                result += resultSet.getString("Name") + " " + resultSet.getString("Surname") + "\n";
        System.out.println(result);
    }
}
