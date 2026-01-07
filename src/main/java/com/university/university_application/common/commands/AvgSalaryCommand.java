package com.university.university_application.common.commands;

import com.university.university_application.service.UniversityService;
import com.university.university_application.util.CommandLineRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
public class AvgSalaryCommand implements CommandLineRequest {
    private final Pattern pattern = Pattern.compile("^Show the average salary for the department ([a-zA-z ]+ {0,2})");
    private final UniversityService service;

    @Override
    public void execute(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            System.out.println("Something went wrong... Try again.");
        }
        String depName = matcher.group(1);
        Optional<BigDecimal> result = service.findAvgSalaryByDepartmentName(depName);
        if (result.isEmpty()) {
            System.out.println("Nothing to show for " + depName);
            return;
        }
        System.out.println(result.get().setScale(2));
    }

    @Override
    public boolean isMatched(String input) {
        return pattern.matcher(input).matches();
    }
}
