package com.crio.jukebox.exception;

public class NoSuchSongExistException  extends Exception{
    public NoSuchSongExistException()
    {
     super();
    }
    public NoSuchSongExistException(String msg)
    {
     super(msg);
    }
}
