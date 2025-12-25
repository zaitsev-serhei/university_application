package com.university.university_application.handler;

import com.university.university_application.service.HelpMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class ConsoleReader implements CommandLineRunner {
    //strict match on letters only. Consider update for additional characters, e.g. '-'
    private final Pattern VALID_PATTER = Pattern.compile("[a-zA-Z ]+");
    private final ConsoleInputHandler handler;
    private final HelpMenuService helpMenu;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("<-- WELCOME TO UNIVERSITY APPLICATION -->");
        System.out.println("# for help /h  #  to quit /q");
        while (true) {
            String input = scanner.nextLine();
            if ("/q".equalsIgnoreCase(input) || "quit".equalsIgnoreCase(input)) {
                System.out.println("THANK YOU AND GOOD BUY");
                break;
            }
            if ("/d".equalsIgnoreCase(input) || "dep".equalsIgnoreCase(input)) {
                helpMenu.showAvailableDepartments();
                continue;
            }
            if ("/h".equalsIgnoreCase(input) || "help".equalsIgnoreCase(input)) {
                helpMenu.showHelpMenu();
                continue;
            }
            if (isValid(input)) {
                if(!handler.handleInput(input)){
                    System.out.println("Unsupported command. Try something else or enter help");
                }
            }
        }
    }

    private boolean isValid(String input) {
        if (input == null || input.length() > 100) {
            System.out.println("Invalid characters in line");
            return false;
        }
        return VALID_PATTER.matcher(input.trim()).matches();
    }
}
