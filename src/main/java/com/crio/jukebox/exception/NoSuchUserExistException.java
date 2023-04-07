package com.crio.jukebox.exception;

public class NoSuchUserExistException extends Exception{
    public NoSuchUserExistException()
    {
     super();
    }
    public NoSuchUserExistException(String msg)
    {
     super(msg);
    }
}
