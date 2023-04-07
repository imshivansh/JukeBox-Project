package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName ("User Test")
public class UserTest {

    @Test
    @DisplayName("check if user is ccreated properly")
    public void checkIfUserCreatedProperly(){
        String id ="1";
        String name = "Sam";
        List<Playlist>playList= new ArrayList<>();

        User expectedUser = new User(id, name,playList);
        User finUser = new User("1","Sam");

        Assertions.assertEquals(expectedUser,finUser);

    } 
    @Test
    @DisplayName("Check is playlist exist")
    public void checkIfPlaylistExistHere(){
        List<String>songId = new ArrayList<>();
        songId.add("1");
        songId.add("2");
        User user = new User("Shivansh");
        Playlist playlist =  new Playlist("1",user.getId(),"shivansh-Playlist",songId);
        Playlist playlist2 =  new Playlist("2",user.getId(),"shivansh-Playlist2",songId);

        user.addPlayList(playlist);
        user.addPlayList(playlist2);
        List<Playlist>ans = user.getPlayList();
        Assertions.assertEquals(2, ans.size());


        
    }
      
}

