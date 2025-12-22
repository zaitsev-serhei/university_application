package com.university.university_application.service.impl;

import com.university.university_application.common.Degree;
import com.university.university_application.domain.model.Lector;
import com.university.university_application.domain.repository.DepartmentRepository;
import com.university.university_application.domain.repository.LectorRepository;
import com.university.university_application.service.UniversityService;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Override
    public Optional<String> findHeadByDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            throw new IllegalArgumentException("Department name is missing");
        }
        return departmentRepository.findHeadByDepartmentName(departmentName);
    }

    @Override
    public Map<Degree, Long> getStatisticForDepartment(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            throw new IllegalArgumentException("Department name is missing");
        }
        List<Lector> lectors = lectorRepository.findLectorsByDepartmentName(departmentName);
        if (!lectors.isEmpty()) {
            return lectors.stream().collect(Collectors.groupingBy(Lector::getDegree, Collectors.counting()));
        }
        return Collections.emptyMap();
    }

    @Override
    public Optional<BigDecimal> findAvgSalaryByDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            throw new IllegalArgumentException("Department name is missing");
        }
        return lectorRepository.findAvgSalaryInDepartment(departmentName);
    }

    @Override
    public Optional<Long> getEmployeeCountByDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            throw new IllegalArgumentException("Department name is missing");
        }
        return lectorRepository.countLectorsByDepartmentName(departmentName);
    }

    @Override
    public List<String> globalSearch(String template) {
        if (template == null || template.isBlank()) {
            throw new IllegalArgumentException("Search template can not be empty");
        }
        return lectorRepository.globalSearchByTemplate(template);
    }
}
