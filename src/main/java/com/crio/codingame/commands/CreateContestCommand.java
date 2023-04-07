package com.crio.codingame.commands;

import java.util.List;
import javax.management.openmbean.InvalidOpenTypeException;
import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.exceptions.InvalidContestException;
import com.crio.codingame.exceptions.NoSuchCommandException;
import com.crio.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IContestService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_CONTEST","CRIODO2_CONTEST","LOW", Monica","40"]
    // or
    // ["CREATE_CONTEST","CRIODO1_CONTEST","HIGH","Ross"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        try{
            Level level;
            String levelString = tokens.get(2);
            Integer questionNum = null;
            if(tokens.size()==5)questionNum = Integer.parseInt(tokens.get(4));
            if(levelString.equals("HIGH"))level=Level.HIGH;
            else if(levelString.equals("LOW"))level=Level.LOW;
            else if(levelString.equals("MEDIUM"))level=Level.MEDIUM;
            else throw new InvalidContestException();
            // System.out.println(tokens.get(1));
            // System.out.println(tokens.get(2));
            // System.out.println(level);
            // System.out.println(questionNum);
            Contest contest =  contestService.create(tokens.get(1),level,tokens.get(3),questionNum);
            System.out.println(contest);

        }catch(RuntimeException e){
            System.out.println(e.getMessage());

        }
          

        

    }
    
}
