package com.university.university_application.common.commands;

import com.university.university_application.service.UniversityService;
import com.university.university_application.util.CommandLineRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
public class GlobalSearchCommand implements CommandLineRequest {
    private final Pattern pattern = Pattern.compile("^Global search by ([a-zA-Z]+)");
    private final UniversityService service;

    @Override
    public void execute(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            System.out.println("Something went wrong...  Try again.");
        }
        String template = matcher.group(1);
        List<String> result = service.globalSearch(template);
        if (result.isEmpty()) {
            System.out.println("No match in global search for " + template + "! Try something else");
        }
        String formattedLine = String.join(", ", result);
        System.out.println(formattedLine);
    }

    @Override
    public boolean isMatched(String input) {
        return pattern.matcher(input).matches();
    }
}
