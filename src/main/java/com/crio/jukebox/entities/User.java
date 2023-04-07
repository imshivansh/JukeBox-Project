package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User extends BaseEntity {
    private final String name;
    private  List<Playlist>playList;
    private String[] currSongNPlaylist;
   
  
    public User(User user){
    this(user.id,user.name);
    playList=user.playList;
    }
    public User(String id, String name,List<Playlist>list){
        this(name);
        this.id=id;
        this.playList= list;  
     }

    public User(String id, String name){
       this(name);
       this.id=id;
       this.playList= new ArrayList<Playlist>();  
    }
    public User(String name){
        this.name=name;
        this.playList = new ArrayList<Playlist>();

    }
  

    public void addPlayList(Playlist playList) {
        this.playList.add(playList);
    }
    public String getName() {
        return name;
    }
    public String getId(){
        return id;

    }
    public String[] getCurrSongNPlaylist() {
        return currSongNPlaylist;
    }
    public void setCurrSongNPlaylist(String[] currSong) {
        this.currSongNPlaylist = currSong;
    }

    public List<Playlist> getPlayList() {
        return playList.stream().collect(Collectors.toList());
     }

    public boolean checkIfPlaylistexist(Playlist checkPlaylist){
        return this.playList.stream().anyMatch(c->c.getId().equals(checkPlaylist.getId()));
       }

    
       public void deletePlayList(Playlist playlist){
        this.playList.removeIf(c->c.getId().equals(playlist.getId()));
       }



    @Override
    public String toString() {
        return "User [name=" + name + ", playList=" + playList + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((playList == null) ? 0 : playList.hashCode());
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
        User other = (User) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (playList == null) {
            if (other.playList != null)
                return false;
        } else if (!playList.equals(other.playList))
            return false;
        return true;
    }

  


 
    


   
    
}
