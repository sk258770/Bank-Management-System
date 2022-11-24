import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;
    Conn() {
    try {
        //creates connections
         c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root");
        //creates statements/Query
         s = c.createStatement();
    }catch (Exception e){

    }
    }
}

