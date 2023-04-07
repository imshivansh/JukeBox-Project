package com.crio.codingame.commands;

import java.util.ArrayList;
import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.exceptions.InvalidOperationException;
import com.crio.codingame.services.IContestService;

public class ListContestCommand implements ICommand{

    private final IContestService contestService;
    
    public ListContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllContestLevelWise method of IContestService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_CONTEST","HIGH"]
    // or
    // ["LIST_CONTEST"]

    @Override
    public void execute(List<String> tokens) {
        List<Contest>contest = new ArrayList<Contest>();
        if(tokens.size()==0)throw new InvalidOperationException();
        Level level ;

        if(tokens.get(0).equals("LIST-CONTEST") && tokens.size()>1 && tokens.get(1)!=null){
            if(tokens.get(1).equals("HIGH"))level =Level.HIGH;
            else if(tokens.get(1).equals("MEDIUM"))level= Level.MEDIUM;
            else level=Level.LOW;
            contest = contestService.getAllContestLevelWise(level);
        }else if(tokens.get(0).equals("LIST-CONTEST") && tokens.size()==1){
            contest = contestService.getAllContestLevelWise(null);

        }
        System.out.println(contest);


        
    }
    
}
