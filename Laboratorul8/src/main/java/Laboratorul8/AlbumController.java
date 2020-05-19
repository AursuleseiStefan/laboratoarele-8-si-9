package Laboratorul8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlbumController {
    public void create(String name,int artistId,int releaseYear)
    {
         Connection conn=Database.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) from albums");
            int nr=0;
            while(rs.next())
                nr=rs.getInt(1);
            rs.close();//le inchid ca nu se corupa datele
            String s="INSERT INTO albums (id,name,artist_id,release_year) VALUES ("+nr+ ",'"+name+"'" + "," + "'" +artistId + "'" + "," + "'" + releaseYear +"'" + ")";
            //este un update
            stmt.executeUpdate(s);//returneaza in caz de eroare
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);//caut getlogger sau print eroare
        }
       /* try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        */
    }
    public void findByArtist(int artistId)
    {
        Connection conn=Database.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            String s= "SELECT name,release_year FROM albums WHERE artist_id=" + "'" + artistId + "'"; 
           ResultSet rs = stmt.executeQuery(s);//returneaza rezultate
           while (rs.next()) {//cat timp am ce citi din resultset
 String name = rs.getString("name"); //rs.getInt(1)(returneaza rezultatul de pe prima coloana) valoarea de pe coloana cu numele name
 int releaseId = rs.getInt("release_year");//retunrneaza un int
 System.out.println(name + ", " + releaseId);
}
        stmt.close();
           rs.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
            try {
                conn.close();
            }
            catch (SQLException a){a.printStackTrace();}
        }

    }
}
