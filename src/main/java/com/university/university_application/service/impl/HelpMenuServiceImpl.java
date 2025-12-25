package com.university.university_application.service.impl;

import com.university.university_application.service.HelpMenuService;
import com.university.university_application.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class HelpMenuServiceImpl implements HelpMenuService {
    private final UniversityService universityService;

    @Override
    public void showHelpMenu() {
        System.out.println("" +
                "\n Available commands are:\n" +
                "/d | dep -- show departments\n" +
                "Who is head of department {department_name}\n" +
                "Show {department_name} statistics.\n" +
                "Show the average salary for the department {department_name}.\n" +
                "Show count of employee for {department_name}.\n" +
                "Global search by {template}.\n" +
                "# -- Make sure to enter proper department name -- #\n"
        );
    }

    @Override
    public void showAvailableDepartments() {
        Set<String> departments =universityService.findAvailableDepartments();
        if(departments.isEmpty()){
            System.out.println("There is no departments yet.");
            return;
        }
        departments.forEach(System.out::println);
    }
}
