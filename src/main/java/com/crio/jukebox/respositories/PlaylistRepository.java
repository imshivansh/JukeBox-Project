package com.crio.jukebox.respositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Playlist;

public class PlaylistRepository implements IplayListServiceRepository{
    private Map<String,Playlist>playlistMap;
    private Integer autoIncrement=0;

    public PlaylistRepository(){
        playlistMap= new HashMap<>();
    }


    @Override
    public Playlist save(Playlist entity) {
        if(entity.getId()==null){
            autoIncrement++;
            Playlist playlist = new Playlist(Integer.toString(autoIncrement),entity.getPlaylistUserId(),entity.getName(),entity.getSongId());
            playlistMap.put(autoIncrement.toString(),playlist);
            return playlist;
        }
        playlistMap.put(entity.getId(),entity);
        return entity;

    }

    @Override
    public List<Playlist> findAll() {
        return playlistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Playlist> findById(String id) {
        return Optional.ofNullable(playlistMap.get(id));
    }

    public Playlist addSongs(String playListId,List<String>songIds){
        Playlist playlist = playlistMap.get(playListId);
        List<String>playListSong = playlist.getSongId();
        for(String str:songIds){
            if(playListSong.contains(str)){
                continue;
            }else{
                playlist.addSong(str);
            } 
        }
        playlistMap.put(playListId,playlist);
        return playlist;
    }
    
   

    @Override
    public boolean existsById(String id) {
        return playlistMap.containsKey(id);
    }

    @Override
    public void delete(Playlist entity) {
        playlistMap.remove(entity.getId());
          
    }

    @Override
    public void deleteById(String id) {
        playlistMap.remove(id);
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public Playlist deleteSong(String playlistId, List<String> songIds) {
        Playlist playlist = playlistMap.get(playlistId);
        List<String>playListSong = playlist.getSongId();
        for(String str:songIds){
            if(!playListSong.contains(str))continue;
            else playlist.deleteSong(str);
        }
        playlistMap.put(playlistId,playlist);
        return playlist;

    }
    
}
