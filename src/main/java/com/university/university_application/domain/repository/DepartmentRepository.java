package com.university.university_application.domain.repository;

import com.university.university_application.domain.model.Department;
import java.util.Optional;

public interface DepartmentRepository {
    Optional<Department> findDepartmentByName(String department);

    Optional<String> findHeadByDepartmentName(String department);

}
