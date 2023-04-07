package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;
import com.crio.jukebox.services.IPlaylistService;
public class PlayPlaylistCommand implements Icommand {
    IPlaylistService playlistService;

    public PlayPlaylistCommand(IPlaylistService playlistService) {
        this.playlistService =playlistService;

    }

    @Override
    public void execute(List<String> tokens) {
        try{
        playlistService.playPlaylist(tokens.get(1), tokens.get(2));
        }catch(RuntimeException | NoSuchUserExistException | PlaylistNotFoundException e){
            System.out.println(e.getMessage());

        }        
    }
    
}
