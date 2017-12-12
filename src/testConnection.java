import java.sql.*;
import java.util.ArrayList;
import java.util.List;




    public class testConnection {

        private static final String URL =
                "jdbc:mysql://134.74.126.107/F17336Gteam3";
        private  static final String USERNAME = "F17336Gteam3";
        private static final String PASSWORD = "metropark";

        private Connection connection;
        private PreparedStatement selectAllStation;




        public testConnection() {
            ResultSet resultSet = null;
            try {

                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                selectAllStation =
                        connection.prepareStatement("SELECT \"IT WORKS!\"");

                resultSet = selectAllStation.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("IT WORKS!"));
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                ;
                System.exit(1);
            } finally {
                try {
                    resultSet.close();

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }







