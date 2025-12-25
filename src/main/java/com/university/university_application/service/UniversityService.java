package com.university.university_application.service;

import com.university.university_application.common.enums.Degree;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface UniversityService {
   Optional<String> findHeadByDepartmentName(String departmentName);

    Map<Degree, Long> getStatisticForDepartment(String departmentName);

    Optional<BigDecimal> findAvgSalaryByDepartmentName(String departmentName);

    Optional<Long> getEmployeeCountByDepartmentName(String departmentName);

    List<String> globalSearch(String template);

    Set<String> findAvailableDepartments();
}
