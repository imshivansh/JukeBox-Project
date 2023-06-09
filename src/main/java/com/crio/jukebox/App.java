package com.crio.jukebox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.exception.*;
import com.crio.jukebox.appConfig.appConfig;


public class App {
    // To run the application  ./gradlew run --args="INPUT_FILE=jukebox-input.txt"
	public static void main(String[] args) throws NoSuchSongExistException, PlaylistNotFoundException, NoSuchUserExistException {
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        String expectedSequence = "INPUT-FILE";
        String actualSequence = commandLineArgs.stream()
                .map(a -> a.split("=")[0])
                .collect(Collectors.joining("$"));
        if(expectedSequence.equals(actualSequence)){
            run(commandLineArgs);
        }
	}

    public static void run(List<String> commandLineArgs) throws NoSuchSongExistException, PlaylistNotFoundException, NoSuchUserExistException {
        appConfig AppConfig = new appConfig();
        CommandInvoker commandInvoker = AppConfig.getCommandInvoker();
        BufferedReader reader;
        String inputFile = commandLineArgs.get(0).split("=")[1];
        commandLineArgs.remove(0);
        try{
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while(line!=null){
                List<String>token =Arrays.asList(line.split(" "));
                List<String>tokens = new ArrayList<>(token);
                commandInvoker.executeCommand(tokens.get(0), tokens);
                line=reader.readLine();
            }
        }catch(IOException | NoSuchCommandException e){
            e.printStackTrace();
        }



    }
}
