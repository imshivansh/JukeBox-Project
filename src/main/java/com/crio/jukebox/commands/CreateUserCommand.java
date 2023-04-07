package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IUserService;


public class CreateUserCommand implements Icommand {
   private final  IUserService userService;
    public CreateUserCommand(IUserService userService2) {
        userService= userService2;
    

    }


    @Override
    public void execute(List<String>createUserCommand){
        String name = createUserCommand.get(1);
         userService.create(name);

    };
    
}
