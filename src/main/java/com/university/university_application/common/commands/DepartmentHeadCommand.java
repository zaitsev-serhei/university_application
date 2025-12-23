package com.university.university_application.common.commands;

import com.university.university_application.service.UniversityService;
import com.university.university_application.util.CommandLineRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
public class DepartmentHeadCommand implements CommandLineRequest {
    private final Pattern pattern=Pattern.compile("^Who is head of department ([a-zA-z]+)");
    private final UniversityService service;
    @Override
    public void execute(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            System.out.println("Something went wrong...");
        }
        String depName = matcher.group(1);
        Optional<String> head = service.findHeadByDepartmentName(depName);
        if(head.isEmpty()){
            System.out.println("There is no head in department");
        }
        System.out.println(head.get());
    }

    @Override
    public boolean isMatched(String input) {
        return pattern.matcher(input).matches();
    }
}
