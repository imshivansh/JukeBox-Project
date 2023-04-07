package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;
import com.crio.jukebox.services.IPlaylistService;

public class DeletePlaylistCommand implements Icommand {
    IPlaylistService playlistService;

    public DeletePlaylistCommand(IPlaylistService playlistService2) {
        this.playlistService = playlistService2;

    }

    @Override
    public void execute(List<String> tokens) {
        try{
        playlistService.deletePlayList(tokens.get(1), tokens.get(2));
        }catch(NoSuchUserExistException | PlaylistNotFoundException e){
            System.out.println(e.getMessage());
        } 


        
    }
    
}
