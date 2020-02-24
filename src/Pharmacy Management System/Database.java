package registrationform;

import com.mysql.jdbc.Connection;
import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    
    
    private Connection conn;
    private Statement statement;
    
    public Connection openConnection() throws SQLException
    {
        if(conn == null)
        {
            String url = "jdbc:mysql://localhost/";
            String dbName = "javadatabase";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "";
            String query = "select * from `admin`";
            
            try{
                Class.forName(driver);
                Connection connection = (Connection)DriverManager.getConnection(url+dbName,userName,password);
                System.out.println("Connection Successfully");
                
                
                java.sql.Statement statement = connection.createStatement();
                ResultSet result;
                result = statement.executeQuery(query);
                //result.next();
                
               // String name = result.getString("userName");
               //l System.out.println("answer is:"+name);
                
                result.beforeFirst();
                while (result.next()) {
                    String username = result.getString("drugName");
                    String email = result.getString("email");
                    String country = result.getString("country");
                   // System.out.println(username+email+country);
                }
                
                connection.close();
                statement.close();
                
            }
            catch(ClassNotFoundException | SQLException sqle)
            {
                System.out.println("Connection Faild");
            }
        }
        return conn;
    }
    
    
}
