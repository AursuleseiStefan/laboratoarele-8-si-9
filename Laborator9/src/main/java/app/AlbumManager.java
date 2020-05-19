package app;

import entity.Albums;
import entity.Artists;
import repo.AlbumRepository;
import repo.ArtistRepository;
import util.PersistenceUtil;


public class AlbumManager {
    public static void main(String[] args){
    Artists artist=new Artists();
    artist.setName("Deliric");
    artist.setCountry("Romania");
    Albums album=new Albums();
    album.setArtistId(9);
    album.setName("DXSS");
    album.setReleaseYear(2018);
    ArtistRepository artistRepository=new ArtistRepository();
    artistRepository.create(artist);
    Artists artist1=artistRepository.findById(4);
    System.out.println(artist1);
    AlbumRepository albumRepository=new AlbumRepository();
    albumRepository.create(album);
    PersistenceUtil.closeFactory();
             
    }
}
