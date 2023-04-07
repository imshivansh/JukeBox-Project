package com.crio.jukebox.entities;

import java.util.List;

public class Song extends BaseEntity{
    private final String name;
    private final String genre;
    private final String albumName;
    private final String songOwner;
    private final List<String>songArtist;

    public Song(String id,String name,String genre,String albumName,String owner,List<String>songArtist){
        this(name,genre,albumName,owner,songArtist);
     this.id=id;

    }
    public Song(String name,String genre,String albumName,String owner,List<String>songArtist){
        this.name=name;
        this.genre=genre;
        this.albumName=albumName;
        this.songOwner=owner;
        this.songArtist=songArtist;

    }
   
    
    public String getName() {
        return name;
    }
   
    public String getGenre() {
        return genre;
    }
   
    public String getAlbumName() {
        return albumName;
    }
  
    public String getSongOwner() {
        return songOwner;
    }
    public List<String> getArtists(){
        return songArtist;
    }

    @Override
    public String toString() {
        return "Current Song Playing  Song - " + name +
         "Album - " + albumName +
        "Artists - " + songArtist;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((albumName == null) ? 0 : albumName.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((songArtist == null) ? 0 : songArtist.hashCode());
        result = prime * result + ((songOwner == null) ? 0 : songOwner.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Song other = (Song) obj;
        if (albumName == null) {
            if (other.albumName != null)
                return false;
        } else if (!albumName.equals(other.albumName))
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (songArtist == null) {
            if (other.songArtist != null)
                return false;
        } else if (!songArtist.equals(other.songArtist))
            return false;
        if (songOwner == null) {
            if (other.songOwner != null)
                return false;
        } else if (!songOwner.equals(other.songOwner))
            return false;
        return true;
    }
  
   

    


    
    
}
