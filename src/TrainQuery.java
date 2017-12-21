import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainQuery {

    private static final String URL =
            "jdbc:mariadb://134.74.126.107/F17336Gteam3";
    private  static final String USERNAME = "F17336Gteam3";
    private static final String PASSWORD = "metropark";

    private Connection connection;
    private PreparedStatement getAllTrain;



    public TrainQuery()
    {
        try
        {

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

             getAllTrain =
                   connection.prepareStatement("SELECT * FROM avail_trains");
        }
        catch (SQLException sqlException)
        {
            System.out.println("Error! Connection cannot be established");
            sqlException.printStackTrace();;
            System.exit(1);
        }
    }

    public List<Train> getAllTrain()
    {
        List<Train> results = null;
        ResultSet resultSet = null;

        try
        {
            resultSet = getAllTrain.executeQuery();
            results = new ArrayList<Train>();

            while(resultSet.next())
            {
                results.add(
                        new Train(
                                resultSet.getInt("train_id"),
                                resultSet.getString("start_station"),
                                resultSet.getString("end_station"),
                                resultSet.getDate("travel_date"),
                                resultSet.getString("time_of_day"),
                                resultSet.getInt("seats_free"),
                                resultSet.getInt("chosen")
                        )
                );

            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch(SQLException sqlException)
            {
                sqlException.printStackTrace();
                close_connection();
            }
        }

        return results;
    }

    public void close_connection()
    {
        try{ connection.close();}
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }


}

