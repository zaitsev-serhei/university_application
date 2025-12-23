package com.university.university_application.common.commands;

import com.university.university_application.common.enums.Degree;
import com.university.university_application.service.UniversityService;
import com.university.university_application.util.CommandLineRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
public class StatisticCommand implements CommandLineRequest {
    private final Pattern pattern = Pattern.compile("^Show ([a-zA-z ]+ {0,2}) statistic");
    private final UniversityService service;

    @Override
    public void execute(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            System.out.println("Something went wrong...  Try again.");
        }
        String depName = matcher.group(1);
        Map<Degree, Long> result = service.getStatisticForDepartment(depName);
        if (result.isEmpty()) {
            System.out.println("Noting to display for department " + depName);
            return;
        }
        result.entrySet().forEach(e -> {
            String formattedKey = e.getKey().toString().toLowerCase().replace("_", " ");
            System.out.println(formattedKey + " - " + e.getValue());
        });
    }

    @Override
    public boolean isMatched(String input) {
        return pattern.matcher(input).matches();
    }
}
