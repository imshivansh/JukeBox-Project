package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;
import com.crio.jukebox.services.IUserService;
public class PlaySongCommand implements Icommand{
    IUserService userService;
 
    public PlaySongCommand(IUserService userService) {
        this.userService = userService;

    }

    @Override
    public void execute(List<String> tokens) {
        try{
           userService.playSong(tokens.get(1),tokens.get(2));
        }catch(RuntimeException | PlaylistNotFoundException | NoSuchUserExistException e){
           e.getMessage();
                }
        
    }
    
}
