package LPIII_N2_WEB_API.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class utils {
    private static Connection connection = null;

    public static Connection getConnection() {
    	
        if (connection != null)
            return connection;
        else {
            try {
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://127.0.0.1:3306";
                String user = "root"; //"scott";
                String password = "1234";//"@@T1ger!"; //"UFLg@9!wytje8NjR"; System.getenv("FTT_PWD");
                
                Class.forName(driver);
                
                connection = DriverManager.getConnection(url, user, password);
                
                System.out.println("JDBC Connected!! - " + new Date());
            
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
          //  } catch (FileNotFoundException e) {
          //      e.printStackTrace();
      //      } catch (IOException e) {
       //         e.printStackTrace();
        //    }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
            return connection;
        }

    }
}
