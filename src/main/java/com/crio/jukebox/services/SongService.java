package com.crio.jukebox.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exception.NoSuchSongExistException;
import com.crio.jukebox.respositories.IsongServiceRepository;
public class SongService implements IsongService {

   IsongServiceRepository isongServiceRepository;

    public SongService(IsongServiceRepository songRepository) {
        isongServiceRepository = songRepository;
    }

    @Override
    public void loadSongData(String fileName) throws IOException {
     BufferedReader reader;
   
       reader = new BufferedReader(new FileReader(fileName));
       String line = reader.readLine();
        while (line!=null)   //returns a Boolean value  
        {  
            String[] songFile = line.split(",");  
            createSong(songFile);
            line = reader.readLine();
        } 
        reader.close();
        System.out.println("Songs Loaded successfully"); 
    }   
   
    @Override
    public void createSong(String[] songFile) {
        String artists[] =  songFile[songFile.length-1].split("#");
        List<String>artistList = Arrays.asList(artists);
        Song song  = new Song(songFile[0],songFile[1],songFile[2],songFile[3],artistList);
        isongServiceRepository.save(song);
        
    }
    public boolean checkIfSongExist(String id) throws NoSuchSongExistException{
       return isongServiceRepository.existsById(id);
        
    }


    
    
}
