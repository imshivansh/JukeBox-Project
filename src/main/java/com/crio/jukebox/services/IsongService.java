package com.crio.jukebox.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IsongService {
    public void loadSongData(String fileName) throws FileNotFoundException, IOException;
    public void createSong(String[]songFile);
    
}
