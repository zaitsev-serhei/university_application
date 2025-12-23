package com.university.university_application.db.adapter;

import com.university.university_application.db.entity.DepartmentEntity;
import com.university.university_application.db.repository.JpaDepartmentRepository;
import com.university.university_application.domain.model.Department;
import com.university.university_application.domain.repository.DepartmentRepository;
import com.university.university_application.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DepartmentAdapter implements DepartmentRepository {
    private final JpaDepartmentRepository jpaRepository;
    private final DepartmentMapper mapper;

    @Override
    public Optional<Department> findDepartmentByName(String department) {
        return jpaRepository.findByNameIgnoreCase(department).map(mapper::toDomain);
    }

    @Override
    public Optional<String> findHeadByDepartmentName(String department) {
        Optional<DepartmentEntity> result = jpaRepository.findByNameIgnoreCase(department);
        if(result.isPresent()){
            return Optional.of(result.get().getHeadName());
        }
        return Optional.empty();
    }
}
