package com.crio.jukebox.services;

import java.util.List;

import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;
import com.crio.jukebox.respositories.IplayListServiceRepository;
import com.crio.jukebox.respositories.IsongServiceRepository;
import com.crio.jukebox.respositories.IuserServiceRepository;


public class UserService implements IUserService {
    IuserServiceRepository uServiceRepository;
    IplayListServiceRepository iplayListServiceRepository;
    IsongServiceRepository isongServiceRepository;

    public UserService(IuserServiceRepository userRepository, IplayListServiceRepository playlistRepository,IsongServiceRepository songServiceRepository) {
        this.uServiceRepository=userRepository;
        this.iplayListServiceRepository=playlistRepository;
        this.isongServiceRepository = songServiceRepository;
    }

    @Override
    public void create(String name) {
        User user = new User(null, name);
        User newUser = uServiceRepository.save(user);
        System.out.println(newUser.getId()+" "+newUser.getName());

        
    
    }

    @Override
    public void playSong(String string2, String string3) throws RuntimeException, PlaylistNotFoundException, NoSuchUserExistException {
        Playlist playList;
        User user =  uServiceRepository.findById(string2).orElseThrow(()->new RuntimeException("User not found"));
        String[] currSongPlList = user.getCurrSongNPlaylist();

        if(currSongPlList[0]==null){
            throw new RuntimeException("Kindly Choose the playlist first to be able to change the song");
        }
        playList = iplayListServiceRepository.findById(currSongPlList[0]).orElseThrow(()->new RuntimeException("Playlist not found"));
        List<String>songId = playList.getSongId();
        if(songId.size()==0){
            System.out.println("Playlist is Empty");
        }
        Integer songidSize = songId.size()-1; //3

        if(string3.equals("BACK")){
            if(currSongPlList[1]=="0"){
                currSongPlList[1]=songidSize.toString();
            }else{
                Integer val = Integer.parseInt(currSongPlList[1])-1;
                currSongPlList[1] = val.toString();
            }

        }else if(string3.equals("NEXT")){
            if(currSongPlList[1]==songidSize.toString()){
                currSongPlList[1]="0";
            }else{
                Integer val= Integer.parseInt(currSongPlList[1])+1;
                if(val<=songidSize){
                    currSongPlList[1]=val.toString();

                }else{
                    currSongPlList[1]="0";
                }
            }
            
        }else{
            boolean checkforvalidId = false;
            for(Integer i =0;i<songId.size();i++){
                if(songId.get(i).equals(string3)){
                    checkforvalidId =true;
                    currSongPlList[1]=i.toString();
                    break;
                }


            }
            if(!checkforvalidId){
                System.out.println("Given song id is not a part of the active playlist");
                throw new RuntimeException("Given song id is not a part of the active playlist");
            }

        }
        String []modifiedSongPlayListId = new String[2];
        modifiedSongPlayListId[0]=playList.getId();
        modifiedSongPlayListId[1]= currSongPlList[1];
        user.setCurrSongNPlaylist(modifiedSongPlayListId);
        String songToBePlayedId = songId.get(Integer.parseInt(currSongPlList[1]));
        Song song  = isongServiceRepository.findById(songToBePlayedId).orElseThrow(()->new RuntimeException("Given song id is not a part of the active playlist"));
        String artList = "";
        List<String>artists = song.getArtists();
        for(String str:artists){
            artList+=str;
            artList+=",";
        }
        String finalString = artList.substring(0,artList.length()-1);
        System.out.println("Current Song Playing");
        System.out.println("Song"+" - "+song.getName());
        System.out.println("Album"+" - "+song.getAlbumName());
        System.out.println("Artists"+" - "+finalString);  

        // TODO Auto-generated method stub
        
    }
    
}