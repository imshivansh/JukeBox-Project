package com.crio.jukebox.respositories;

import java.util.List;
import com.crio.jukebox.entities.Playlist;

public interface IplayListServiceRepository extends CRUDRepository<Playlist,String>{

    Playlist addSongs(String playlistId,List<String> songIds);

    Playlist deleteSong(String playlistId, List<String> songIds);
    
}
