package com.university.university_application.db.repository;

import com.university.university_application.db.entity.LectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface JpaLectorRepository extends JpaRepository<LectorEntity,Long> {
    @Query(value="" +
            "SELECT l.* " +
            "FROM department_assignments as da " +
            "JOIN departments d ON da.dep_id=d.id " +
            "JOIN lectors l on da.lec_id=l.id " +
            "where d.name =:department ;", nativeQuery=true)
    List<LectorEntity> findLectorsByDepartmentName(@Param("department") String department);

    @Query(value="SELECT AVG(l.salary) FROM department_assignments AS da " +
            "JOIN departments d ON d.id = da.dep_id " +
            "JOIN lectors l ON l.id =da.lec_id " +
            "WHERE d.name = :department " +
            "GROUP BY d.name ;", nativeQuery=true)
    Optional<BigDecimal> findAvgSalaryByDepartmentName(@Param("department") String department);

    @Query(value="SELECT COUNT(*) FROM department_assignments AS da " +
            "JOIN departments d ON d.id=da.dep_id " +
            "WHERE d.name =:department;", nativeQuery=true)
    Optional<Long> countLectorByDepartmentName(@Param("department") String department);

    @Query(value="SELECT l.* FROM department_assignments AS da " +
            "JOIN departments d ON da.dep_id=d.id " +
            "JOIN lectors l ON da.lec_id=l.id " +
            "WHERE l.first_name LIKE '%:template%' OR l.last_name LIKE '%:template%';", nativeQuery=true)
    List<LectorEntity> findLectorByTemplate(@Param("template") String template);
}
