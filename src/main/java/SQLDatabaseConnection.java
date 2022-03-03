import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        
        
        String conString = "jdbc:mysql://localhost:3306/emaildatabase?user=root";
        
        ResultSet resultSet = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try (Connection connection = DriverManager.getConnection(conString, "root", "Airsoft1!");
                Statement statement = connection.createStatement();) {
            
            System.out.println("CONNECTION SUCCEEDED");

            // Create and execute a SELECT SQL statement.
            String query = "INSERT INTO email VALUES ('blarbaman@gmail.com', 'content', 'company name', 'job title') ";
            
            for (int i = 0; i < 250; i++) {
                statement.executeUpdate(query);
            }
            

            // Print results from select statement
//            while (resultSet.next()) {
//                System.out.println(resultSet);
//                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
//            }
            
            //added myself ??
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}