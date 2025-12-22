package com.university.university_application.db.repository;

import com.university.university_application.db.entity.LectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLectorRepository extends JpaRepository<LectorEntity,Long> {

}
