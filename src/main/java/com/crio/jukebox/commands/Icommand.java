package com.crio.jukebox.commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import com.crio.jukebox.exception.NoSuchSongExistException;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;

public interface  Icommand {
    public void execute(List<String>tokens) throws NoSuchSongExistException, PlaylistNotFoundException, NoSuchUserExistException, FileNotFoundException, IOException;
    
    
}
