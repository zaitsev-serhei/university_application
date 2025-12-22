package com.university.university_application.domain.repository;

import com.university.university_application.domain.model.Lector;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface LectorRepository {
    List<Lector> findLectorsByDepartmentName(String department);

    Optional<BigDecimal> findAvgSalaryInDepartment(String department);

    Optional<Long> countLectorsByDepartmentName(String department);

    List<String> globalSearchByTemplate(String template);
}
