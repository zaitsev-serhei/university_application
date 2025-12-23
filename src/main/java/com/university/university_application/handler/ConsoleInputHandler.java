package com.university.university_application.handler;

import com.university.university_application.util.CommandLineRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsoleInputHandler {
    private final List<CommandLineRequest> supportedCommandList;

    public boolean handleInput(String input) {
        boolean handled =false;
        //System.out.println(supportedCommandList.toString());
        for(CommandLineRequest command : supportedCommandList ){
            if(command.isMatched(input)){
                command.execute(input);
                handled = true;
            }
        }
        return handled;
    }
}
