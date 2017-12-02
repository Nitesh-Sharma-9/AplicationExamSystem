import java.sql.*;
public class Admin 
{
  /* static Connection connect() throws Exception
   {
     Class.forName("com.mysql.jdbc.Driver");
     return DriverManager.getConnection("jdbc:mysql://localhost:3306/agile","root","");
   }*/
   static Connection connectO() throws Exception
    {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
   }
   
}