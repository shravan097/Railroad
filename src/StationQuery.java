import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StationQuery {

    private static final String URL =
            "jdbc:mariadb://134.74.126.107/F17336Gteam3";
    private  static final String USERNAME = "F17336Gteam3";
    private static final String PASSWORD = "metropark";

    private Connection connection;
    private PreparedStatement selectAllStation;



    public StationQuery()
    {
        try
        {

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

           // selectAllStation =
             //       connection.prepareStatement("SELECT * FROM stations");
        }
        catch (SQLException sqlException)
        {
		System.out.println("Error! Connection cannot be established");
            sqlException.printStackTrace();;
            System.exit(1);
        }
    }

    public List<Station> getAllStation()
    {
        List<Station> results = null;
        ResultSet resultSet = null;

        try
        {
            resultSet = selectAllStation.executeQuery();
            results = new ArrayList<Station>();

            while(resultSet.next())
            {
                results.add(
                        new Station(
                                resultSet.getInt("station_id"),
                                resultSet.getString("station_name"),
                                resultSet.getString("station_symbol")
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

