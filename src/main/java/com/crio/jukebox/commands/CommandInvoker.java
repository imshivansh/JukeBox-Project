package com.crio.jukebox.commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crio.jukebox.exception.NoSuchCommandException;
import com.crio.jukebox.exception.NoSuchSongExistException;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;

public class CommandInvoker {
    private static final Map<String,Icommand>commandMap= new HashMap<>();

    public void register(String commandName,Icommand command){
        commandMap.put(commandName,command);
    }

    public Icommand getCommand(String commandName){
        return commandMap.get(commandName);
    }
    
    public void executeCommand(String commandName,List<String>tokens)throws NoSuchCommandException, NoSuchSongExistException, PlaylistNotFoundException, NoSuchUserExistException, FileNotFoundException, IOException{
        Icommand command = getCommand(commandName);

      
        if(command==null){
            throw new NoSuchCommandException("Command provided by the user is not Valid");

        }
        command.execute(tokens);
        
    }
    
}
