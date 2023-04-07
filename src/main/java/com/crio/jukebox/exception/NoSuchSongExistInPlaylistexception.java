package com.crio.jukebox.exception;

public class NoSuchSongExistInPlaylistexception extends Exception {
    public NoSuchSongExistInPlaylistexception()
    {
     super();
    }
    public NoSuchSongExistInPlaylistexception(String msg)
    {
     super(msg);
    }
}
