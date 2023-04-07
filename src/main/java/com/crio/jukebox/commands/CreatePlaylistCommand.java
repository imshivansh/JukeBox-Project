package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.exception.NoSuchSongExistException;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;
import com.crio.jukebox.services.IPlaylistService;

public class CreatePlaylistCommand implements Icommand {

private final IPlaylistService playlistService;
    public CreatePlaylistCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokens) throws NoSuchSongExistException, PlaylistNotFoundException, NoSuchUserExistException {
        try{
            List<String>songIDs = new ArrayList<>();
            for(int i =3;i<tokens.size();i++){
                songIDs.add(tokens.get(i));
            }

            Playlist playlist = new Playlist(tokens.get(1),tokens.get(2), songIDs);
             playlistService.createPlayList(playlist);
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            //TODO: handle exception
        }
        
    }
    
}
