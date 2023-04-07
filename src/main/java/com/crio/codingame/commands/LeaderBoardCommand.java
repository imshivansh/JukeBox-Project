package com.crio.codingame.commands;

import java.util.ArrayList;
import java.util.List;

import com.crio.codingame.entities.ScoreOrder;
import com.crio.codingame.entities.User;
import com.crio.codingame.services.IUserService;

public class LeaderBoardCommand implements ICommand{

    private final IUserService userService;
    
    public LeaderBoardCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllUserScoreOrderWise method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LEADERBOARD","ASC"]
    // or
    // ["LEADERBOARD","DESC"]

    @Override
    public void execute(List<String> tokens) {
        List<User>ans = new ArrayList<>();
        ScoreOrder scoreOrder;
        try{
            if(tokens.get(1).equals("ASC"))scoreOrder=ScoreOrder.ASC;
            else scoreOrder=ScoreOrder.DESC;
            
            ans = userService.getAllUserScoreOrderWise(scoreOrder);
            System.out.println(ans);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
}
