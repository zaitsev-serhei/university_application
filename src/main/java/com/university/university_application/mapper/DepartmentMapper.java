package com.university.university_application.mapper;

import com.university.university_application.db.entity.DepartmentEntity;
import com.university.university_application.domain.model.Department;
import org.springframework.stereotype.Component;
/*
    Consider mapstruck library usage for auto-generation of mappers
 */
@Component
public class DepartmentMapper {

    public DepartmentEntity toEntity(Department department){
        DepartmentEntity entity = new DepartmentEntity();
        entity.setId(department.getId());
        entity.setName(department.getName());
        entity.setHeadName(department.getHeadName());
        return entity;
    }
    public Department toDomain(DepartmentEntity entity){
        Department department = new Department();
        department.setId(entity.getId());
        department.setName(entity.getName());
        department.setHeadName(entity.getHeadName());
        return department;
    }
}
