package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.exception.NoSuchSongExistException;
import com.crio.jukebox.exception.NoSuchSongExistInPlaylistexception;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;
import com.crio.jukebox.services.IPlaylistService;

public class ModifyPlaylistCommand implements Icommand{
    IPlaylistService playlistService;

    public ModifyPlaylistCommand(IPlaylistService playlistService) {
        this.playlistService=playlistService;
    }


    @Override
    public void execute(List<String> tokens) {
        List<String>songIDs = new ArrayList<>();
        for(int i =4;i<tokens.size();i++){
            songIDs.add(tokens.get(i));
        }
        try {
            playlistService.modifyPlaylist(tokens.get(1),tokens.get(2), tokens.get(3), songIDs);
        } catch (RuntimeException | PlaylistNotFoundException | NoSuchUserExistException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchSongExistException e) {
            System.out.println(e.getMessage());

        } catch (NoSuchSongExistInPlaylistexception e) {
            System.out.println(e.getMessage());

        }
              
    }
    
}
