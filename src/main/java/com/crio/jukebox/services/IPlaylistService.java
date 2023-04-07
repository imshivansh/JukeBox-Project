package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.exception.NoSuchSongExistException;
import com.crio.jukebox.exception.NoSuchSongExistInPlaylistexception;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;

public interface IPlaylistService {
    public void createPlayList(Playlist playlist) throws NoSuchSongExistException, RuntimeException, PlaylistNotFoundException, NoSuchUserExistException;
    public void deletePlayList(String userId,String playListId) throws NoSuchUserExistException, PlaylistNotFoundException;
    public void modifyPlaylist(String actionType,String userId,String playlistId,List<String>songIds) throws RuntimeException, PlaylistNotFoundException, NoSuchUserExistException, NoSuchSongExistException, NoSuchSongExistInPlaylistexception; 
    public void  playPlaylist(String userId,String playlistId) throws NoSuchUserExistException, PlaylistNotFoundException;


    
}
