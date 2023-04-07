package com.crio.jukebox.exception;

public class PlaylistNotFoundException extends Exception {
    public PlaylistNotFoundException()
    {
     super();
    }
    public PlaylistNotFoundException(String msg)
    {
     super(msg);
    }
}
