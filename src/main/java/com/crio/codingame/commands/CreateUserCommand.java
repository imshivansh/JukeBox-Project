package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.User;
import com.crio.codingame.exceptions.InvalidOperationException;
import com.crio.codingame.services.IUserService;

public class CreateUserCommand implements ICommand{

    private final IUserService userService;
    
    public CreateUserCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_QUESTION","Ross"]

    //   @DisplayName("execute method of CreateUserCommand Should Print newly Created User To Console")
    // public void execute_ShouldPrintQuestion() {
    //     //Arrange
    //     String expectedOutput = "User [id=1, contests=[], name=name, score=0]";
    //     User user = new User("1","name",0);
    //     when(userServiceMock.create("name")).thenReturn(user);

    //     //Act
    //     createUserCommand.execute(List.of("CREATE-USER","name"));

    //     //Assert
    //     Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());

    //     verify(userServiceMock,times(1)).create(anyString());
    // }


    @Override
    public void execute(List<String> tokens) {
        if(tokens.size()<=1) throw new InvalidOperationException(" the provided argument is not valid");
        if(tokens.size()>1 && tokens.get(0).equals("CREATE-USER")){

          User user =  userService.create(tokens.get(1));
        System.out.println(user);
        }

    }
    
}
