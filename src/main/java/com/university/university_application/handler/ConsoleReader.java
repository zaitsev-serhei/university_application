package com.university.university_application.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class ConsoleReader implements CommandLineRunner {
    private final Pattern VALID_PATTER = Pattern.compile("[a-zA-Z ]+");
    private final ConsoleInputHandler handler;

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
            if ("/h".equalsIgnoreCase(input) || "help".equalsIgnoreCase(input)) {
                helpMenu();
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
            return false;
        }
        return VALID_PATTER.matcher(input.trim()).matches();
    }

    private void helpMenu() {
        System.out.println("" +
                "\n Available commands are:\n" +
                "Who is head of department {department_name}\n" +
                "Show {department_name} statistics.\n" +
                "Show the average salary for the department {department_name}.\n" +
                "Show count of employee for {department_name}.\n" +
                "Global search by {template}.\n" +
                "# -- Make sure to enter proper department name -- #\n"
        );
    }
}
