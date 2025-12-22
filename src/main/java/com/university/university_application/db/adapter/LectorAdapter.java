package com.university.university_application.db.adapter;

import com.university.university_application.db.entity.LectorEntity;
import com.university.university_application.db.repository.JpaLectorRepository;
import com.university.university_application.domain.model.Lector;
import com.university.university_application.domain.repository.LectorRepository;
import com.university.university_application.mapper.LectorMapper;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LectorAdapter implements LectorRepository {
    private final JpaLectorRepository jpaRepository;
    private final LectorMapper mapper;

    @Override
    public List<Lector> findLectorsByDepartmentName(String department) {
        return jpaRepository.findLectorsByDepartmentName(department).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<BigDecimal> findAvgSalaryInDepartment(String department) {
        return jpaRepository.findAvgSalaryByDepartmentName(department);
    }

    @Override
    public Optional<Long> countLectorsByDepartmentName(String department) {
        return jpaRepository.countLectorByDepartmentName(department);
    }

    @Override
    public List<String> globalSearchByTemplate(String template) {
        List<LectorEntity> searchResult = jpaRepository.findLectorByTemplate(template);
        if(!searchResult.isEmpty()){
            return searchResult.stream().map(r->r.getFirstName()+" "+ r.getLastName()).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
