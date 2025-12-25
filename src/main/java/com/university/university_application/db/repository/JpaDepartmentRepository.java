package com.university.university_application.db.repository;

import com.university.university_application.db.custom.DepartmentName;
import com.university.university_application.db.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface JpaDepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    Optional<DepartmentEntity> findByNameIgnoreCase(String department);
    //should align with labels in db or be as now to use lable from projection
    List<DepartmentName> findAllBy();
}
