package com.university.university_application.service.impl;

import com.university.university_application.common.enums.Degree;
import com.university.university_application.domain.model.Department;
import com.university.university_application.domain.model.Lector;
import com.university.university_application.domain.repository.DepartmentRepository;
import com.university.university_application.domain.repository.LectorRepository;
import com.university.university_application.service.UniversityService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;
    private Set<String> cachedDepartments = new HashSet<>();

    @PostConstruct
    private void initCache(){
        this.cachedDepartments=new HashSet<>(departmentRepository.findAllDepartmentNames());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<String> findHeadByDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            throw new IllegalArgumentException("Department name is missing");
        }
        return departmentRepository.findHeadByDepartmentName(departmentName);
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    @Override
    public Optional<BigDecimal> findAvgSalaryByDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            throw new IllegalArgumentException("Department name is missing");
        }
        return lectorRepository.findAvgSalaryInDepartment(departmentName);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Long> getEmployeeCountByDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            throw new IllegalArgumentException("Department name is missing");
        }
        return lectorRepository.countLectorsByDepartmentName(departmentName);
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> globalSearch(String template) {
        if (template == null || template.isBlank()) {
            throw new IllegalArgumentException("Search template can not be empty");
        }
        return lectorRepository.globalSearchByTemplate(template);
    }
    @Transactional(readOnly = true)
    @Override
    public Set<String> findAvailableDepartments() {
        //returning safe set of String not to be modified elsewhere
        return Collections.unmodifiableSet(this.cachedDepartments);
    }
}
