package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;

public class Playlist extends BaseEntity {
    
    private  String name;
    private final String PlaylistUserId;
    List<String>songId;
    public Playlist(Playlist playlist){
        this(playlist.getId(),playlist.getPlaylistUserId(),playlist.getName(),playlist.getSongId());
    }


    public Playlist(String id,String userId,String name,List<String>songIdList){
        this(userId,name,songIdList);
        this.id=id;
    }
    public Playlist(String userId,String name,List<String>songId2){
        this(name,userId);
        this.songId=songId2;
    }
    public Playlist(String name,String userId){
        this.name=name;
        this.PlaylistUserId=userId;
        this.songId = new ArrayList<String>();
    }
    public String getName() {
        return name;
    }
    public String getPlaylistUserId() {
        return PlaylistUserId;
    }
    public List<String> getSongId() {
        return songId;
    }
    public void setSongId(List<String>songId) {
        this.songId = songId;
    }
    public void setName(String name){
        this.name=name;
    }

    public void addSong(String songId)throws RuntimeException{
        if(this.songId.contains(songId)){
            System.out.println("Song Already exist");
            throw new RuntimeException("Song Already present");
        }else{
            this.songId.add(songId);
        }
    }


    
    public boolean checkifSongExistInPlaylist(String str) {
        return this.songId.contains(str);
    }

    public void deleteSong(String str) {
        this.songId.removeIf(c->c.equals(str));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((PlaylistUserId == null) ? 0 : PlaylistUserId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((songId == null) ? 0 : songId.hashCode());
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
        Playlist other = (Playlist) obj;
        if (PlaylistUserId == null) {
            if (other.PlaylistUserId != null)
                return false;
        } else if (!PlaylistUserId.equals(other.PlaylistUserId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (songId == null) {
            if (other.songId != null)
                return false;
        } else if (!songId.equals(other.songId))
            return false;
        return true;
    }


    
}
