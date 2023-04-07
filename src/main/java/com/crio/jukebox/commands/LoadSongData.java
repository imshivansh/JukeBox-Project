package com.crio.jukebox.commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import com.crio.jukebox.services.IsongService;

public class LoadSongData implements Icommand {
    IsongService songService;

    public LoadSongData(IsongService songService) {
        this.songService=songService;
    }

    @Override
    public void execute(List<String> tokens) throws FileNotFoundException, IOException {
        try{
            String songFile = tokens.get(1);
            songService.loadSongData(songFile);

        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
              
    }
    
}
