package com.crio.jukebox.appConfig;
import com.crio.jukebox.commands.CreateUserCommand;
import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.commands.CreatePlaylistCommand;
import com.crio.jukebox.commands.DeletePlaylistCommand;
import com.crio.jukebox.commands.ModifyPlaylistCommand;
import com.crio.jukebox.commands.PlayPlaylistCommand;
import com.crio.jukebox.commands.PlaySongCommand;
import com.crio.jukebox.commands.LoadSongData;

import com.crio.jukebox.respositories.IuserServiceRepository;
import com.crio.jukebox.respositories.PlaylistRepository;
import com.crio.jukebox.respositories.SongRepository;
import com.crio.jukebox.respositories.UserRepository;
import com.crio.jukebox.respositories.IplayListServiceRepository;
import com.crio.jukebox.respositories.IsongServiceRepository;
import com.crio.jukebox.services.IPlaylistService;
import com.crio.jukebox.services.IUserService;
import com.crio.jukebox.services.IsongService;
import com.crio.jukebox.services.PlaylistService;
import com.crio.jukebox.services.UserService;
import com.crio.jukebox.services.SongService;




public class appConfig {
private final IsongServiceRepository songRepository = new SongRepository();
private final IuserServiceRepository userRepository = new UserRepository();
private final IplayListServiceRepository playlistRepository = new PlaylistRepository();

private final IsongService songService = new SongService(songRepository);
private final IUserService userService = new UserService(userRepository, playlistRepository,songRepository);
private final IPlaylistService playlistService= new PlaylistService(userRepository, playlistRepository,songRepository);

private final CommandInvoker commandInvoker = new CommandInvoker();
private final CreatePlaylistCommand  createPlaylistCommand = new CreatePlaylistCommand(playlistService);
private final CreateUserCommand createUserCommand = new CreateUserCommand(userService);
private final LoadSongData loadSongData = new LoadSongData(songService);
private final DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
private final ModifyPlaylistCommand modifyPlaylistCommand = new ModifyPlaylistCommand(playlistService);
private final PlayPlaylistCommand playPlaylistCommand = new PlayPlaylistCommand(playlistService);
private final PlaySongCommand playSongCommand = new PlaySongCommand(userService);
public CommandInvoker getCommandInvoker(){
    commandInvoker.register("LOAD-DATA",loadSongData);
    commandInvoker.register("CREATE-USER", createUserCommand);
    commandInvoker.register("MODIFY-PLAYLIST", modifyPlaylistCommand);
    commandInvoker.register("DELETE-PLAYLIST",deletePlaylistCommand);
    commandInvoker.register("CREATE-PLAYLIST", createPlaylistCommand);
    commandInvoker.register("PLAY-PLAYLIST", playPlaylistCommand);
    commandInvoker.register("PLAY-SONG", playSongCommand);
    return commandInvoker;
}
}
