package com.university.university_application.service;

import com.university.university_application.common.Degree;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UniversityService {
//    User Input: Who is head of department {department_name}
//    Answer: Head of {department_name} department is {head_of_department_name}
   Optional<String> findHeadByDepartmentName(String departmentName);
//    User Input: Show {department_name} statistics.
//            Answer: assistans - {assistams_count}.
//    associate professors - {associate_professors_count}
//    professors -{professors_count}
    Map<Degree, Long> getStatisticForDepartment(String departmentName);
//3. User Input: Show the average salary for the department {department_name}.
//    Answer: The average salary of {department_name} is {average_salary}
    Optional<BigDecimal> findAvgSalaryByDepartmentName(String departmentName);
//4. User Input: Show count of employee for {department_name}.
//    Answer: {employee_count}
    Optional<Long> getEmployeeCountByDepartmentName(String departmentName);
//5. User Input: Global search by {template}.
//    Example: Global search by van
//    Answer: Ivan Petrenko, Petro Ivanov
    List<String> globalSearch(String template);
}
