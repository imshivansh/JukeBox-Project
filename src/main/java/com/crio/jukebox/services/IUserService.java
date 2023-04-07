package com.crio.jukebox.services;

import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;

public interface IUserService {
    public void create(String name);

    public void playSong(String string2, String string3) throws RuntimeException, PlaylistNotFoundException, NoSuchUserExistException;
    
}
