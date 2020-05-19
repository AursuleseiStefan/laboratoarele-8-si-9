package Laboratorul8;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
       ArtistController artisti=new ArtistController();

       //artisti.create("Doc", "Romania");
       //artisti.create("Deliric", "Romania");
       //artisti.create("G-Eazy","SUA");
        //artisti.create("Post Malone","SUA");
       artisti.findByName("Post Malone");
       AlbumController albumea=new AlbumController();
       //albumea.create("Stoney", 4, 2016);
       albumea.findByArtist(4);
       Connection conn=Database.getInstance().getConnection();
       conn.close();
    }
}
