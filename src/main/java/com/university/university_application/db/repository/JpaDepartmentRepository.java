package com.university.university_application.db.repository;

import com.university.university_application.db.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JpaDepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    Optional<DepartmentEntity> findByName();

}
