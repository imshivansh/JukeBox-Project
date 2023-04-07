package com.crio.jukebox.respositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exception.NoSuchSongExistException;

public class SongRepository implements IsongServiceRepository {
    Map<String,Song>songMap;
    Integer autoIcrement;

    public SongRepository(){
        songMap= new HashMap<>();
        autoIcrement = 0;

    }

    @Override
    public Song save(Song entity) {
        if(entity.getId()==null){
            autoIcrement++;
            Song song = new Song(autoIcrement.toString(), entity.getName(), entity.getGenre(), entity.getAlbumName(), entity.getSongOwner(), entity.getArtists());
            songMap.put(autoIcrement.toString(),song);
            return song;

        }
        songMap.put(entity.getId(),entity);
        return entity;
        
    }

    @Override
    public List<Song> findAll() {
        return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Song> findById(String id) {
        return Optional.ofNullable(songMap.get(id));
    }

    @Override
    public boolean existsById(String id)throws NoSuchSongExistException{
        return (songMap.containsKey(id))?true:false;
        
    }

    @Override
    public void delete(Song entity) {
        
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
