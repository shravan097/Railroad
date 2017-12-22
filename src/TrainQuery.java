import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainQuery {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/F17336Gteam3";
    private  static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    private PreparedStatement clearPastTrain;
    private PreparedStatement getAllTrain;
    private CallableStatement get_avail_train;




    public TrainQuery()
    {
        try
        {

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            clearPastTrain = connection.prepareStatement("TRUNCATE TABLE avail_trains;");
             getAllTrain =
                   connection.prepareStatement("SELECT * FROM avail_trains");
            get_avail_train = connection.prepareCall("{CALL get_avail_trains(?, ?,?,?, ?, @some_trains)}");

        }
        catch (SQLException sqlException)
        {
            System.out.println("Error! Connection cannot be established");
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public List<Train> getAllTrain(String date,String start_station, String end_station,String time_of_day, String day_of_week)
    {
        List<Train> result = null;
        try
        {
            clearPastTrain.executeQuery();
            get_avail_train.setString(1,date);
            get_avail_train.setString(2,start_station);
            get_avail_train.setString(3,end_station);
            get_avail_train.setString(4,time_of_day);
            get_avail_train.setString(5,day_of_week);
            if(get_avail_train.execute())
            {
                System.out.println("SP Available_train did not execute properly!");
                System.exit(1);
            }
            result = getAllTrain();

        }
        catch( Exception e)
        {
            e.printStackTrace();
        }
        return result;
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

