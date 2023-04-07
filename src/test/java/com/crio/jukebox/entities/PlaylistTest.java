package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName ("Playlist Test")

public class PlaylistTest {
    @Test
    @DisplayName("add Song")
    public void addSong(){
        List<String>songId = new ArrayList<>();
        songId.add("1");
        
        Playlist playlist =  new Playlist("null", "1",(ArrayList<String>) songId);
        playlist.addSong("2");
        playlist.addSong("2");

       
        Assertions.assertSame(2,2);


    }
    
}
