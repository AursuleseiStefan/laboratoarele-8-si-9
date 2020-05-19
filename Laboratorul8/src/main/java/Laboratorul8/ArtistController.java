package Laboratorul8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArtistController {
    public void create (String name,String country)
    {
        Connection conn=Database.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) from artists");
            int nr=0;
            while(rs.next())
                nr=rs.getInt(1);

            String s = "INSERT INTO artists (id,name,country) VALUES("+nr+","+"'"+name+"'"+",'"+country+"')";
            stmt.executeUpdate(s);
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
        }
            /* }finally {
            try {
                conn.close();
            }
            catch (SQLException a){a.printStackTrace();}
        }
        */
    }
    public void findByName(String name)
    {
        Connection conn=Database.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            String s= "SELECT ID,COUNTRY FROM ARTISTS WHERE name=" + "'" + name + "'"; 
           ResultSet rs = stmt.executeQuery(s);
           while (rs.next()) {
 int cod = rs.getInt("id"); //rs.getInt(1)
 String country = rs.getString("country");
 System.out.println(cod + ", " + country);
}

           
        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
