package com.crio.jukebox.services;

import java.util.List;

import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exception.NoSuchSongExistException;
import com.crio.jukebox.exception.NoSuchSongExistInPlaylistexception;
import com.crio.jukebox.exception.NoSuchUserExistException;
import com.crio.jukebox.exception.PlaylistNotFoundException;
import com.crio.jukebox.respositories.IplayListServiceRepository;
import com.crio.jukebox.respositories.IsongServiceRepository;
import com.crio.jukebox.respositories.IuserServiceRepository;


public class PlaylistService implements IPlaylistService{
    IplayListServiceRepository iplayListServiceRepository;
    IuserServiceRepository iuserServiceRepository;
    IsongServiceRepository isongServiceRepository;

    public PlaylistService(IuserServiceRepository userRepository, IplayListServiceRepository playlistRepository,IsongServiceRepository songServiceRepository) {
        iplayListServiceRepository= playlistRepository;
        iuserServiceRepository=userRepository;
        isongServiceRepository= songServiceRepository;
    }

    @Override
    public void createPlayList(Playlist entity) throws NoSuchSongExistException, RuntimeException, PlaylistNotFoundException, NoSuchUserExistException {
        List<String>songIds = entity.getSongId();
        for (String string : songIds) {
            if(isongServiceRepository.existsById(string))continue;
            else{
                System.out.println("Some Requested Songs Not Available. Please try again.");
                throw new NoSuchSongExistException("Some Requested Songs Not Available. Please try again.");
            } 
        }
       Playlist playlist = iplayListServiceRepository.save(entity);
       User user  =  iuserServiceRepository.findById(playlist.getPlaylistUserId()).orElseThrow(()->new RuntimeException("No Such user exist"));
       user.addPlayList(playlist);
       System.out.println("Playlist - ID "+playlist.getId());

        // TODO Auto-generated method stub
    }

    @Override
    public void deletePlayList(String userId, String playListId) throws NoSuchUserExistException, PlaylistNotFoundException{
   
           User user  = iuserServiceRepository.findById(userId).orElseThrow(()->new NoSuchUserExistException("User not found"));  
            Playlist playlist = iplayListServiceRepository.findById(playListId).orElseThrow(()->new RuntimeException("playlist not found"));
           if(user.checkIfPlaylistexist(playlist)){
            user.deletePlayList(playlist);
            iplayListServiceRepository.delete(playlist);
            System.out.print("Delete Successful\n");
           }else{
            System.out.println("Playlist Not Found");
           }
       
    }

    @Override
    public void modifyPlaylist(String actionId,String userId, String playlistId, List<String> songIds) throws RuntimeException, PlaylistNotFoundException, NoSuchUserExistException, NoSuchSongExistException, NoSuchSongExistInPlaylistexception {
            Playlist playlist2;
            User user = iuserServiceRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
            Playlist playlist =  iplayListServiceRepository.findById(playlistId).orElseThrow(()->new RuntimeException("Playlist not found"));
            if(user.checkIfPlaylistexist(playlist)){
                for(String str:songIds){
                  
                        if(isongServiceRepository.existsById(str))continue;
                        else throw new NoSuchSongExistException("Some Requested Songs Not Available. Please try again.");  
                }
            }
            if(actionId.equals("ADD-SONG")){
               playlist2= iplayListServiceRepository.addSongs(playlistId,songIds);
               
               user.deletePlayList(playlist);
               user.addPlayList(playlist2);
               List<String>Ids = playlist2.getSongId();
               String ans = "";
               for(int i =0;i<Ids.size();i++){
                ans+=Ids.get(i);
                ans+=" ";
               }
               System.out.println("Playlist ID - "+playlist2.getId());
               System.out.println("Playlist Name - "+playlist2.getName()); 
               System.out.println("Song IDs"+" - "+ans.substring(0,ans.length()-1));
        }else{
            for(String str:songIds){
                boolean val = playlist.checkifSongExistInPlaylist(str);
                if(val)continue;
                else throw new NoSuchSongExistInPlaylistexception("Some Requested Songs Not Available. Please try again.");  
        }
                playlist2 = iplayListServiceRepository.deleteSong(playlistId,songIds);
                user.deletePlayList(playlist);
                user.addPlayList(playlist2);
               
                List<String>songId = playlist2.getSongId();
                String ans = "";
                for(int i =0;i<songId.size();i++){
                 ans+=songId.get(i);
                 ans+=" ";
                }
                System.out.print("Playlist ID - "+playlist2.getId()+"\n");
                System.out.print("Playlist Name - "+playlist2.getName()+"\n");
                System.out.println("Song IDs"+" - "+ans.substring(0,ans.length()-1));

            }
            

        
    }

   

    @Override
    public void playPlaylist(String userId, String playlistId) throws NoSuchUserExistException, PlaylistNotFoundException {
        User user = iuserServiceRepository.findById(userId).orElseThrow(()->new NoSuchUserExistException("User not found"));
        Playlist playlist =user.getPlayList().stream().filter(c->c.getId().equals(playlistId)).findAny().get();
        List<String>songId =playlist.getSongId();
        if(songId.size()==0)throw new RuntimeException("Playlist is Empty");
        Song song = isongServiceRepository.findById(songId.get(0)).orElseThrow(()->new RuntimeException());
        String[] currPlaylistNSong = new String[2];
        currPlaylistNSong[0]=playlistId;
        currPlaylistNSong[1]="0";
        user.setCurrSongNPlaylist(currPlaylistNSong);
        String artList = "";
        List<String>artists = song.getArtists();
        for(String str:artists){
            artList+=str;
            artList+=",";
        }
        String finalArtist = artList.substring(0,artList.length()-1);
        System.out.println("Current Song Playing");
        System.out.println("Song - "+song.getName());
        System.out.println("Album - "+song.getAlbumName());
        System.out.println("Artists - "+finalArtist);  
    }
    
}
