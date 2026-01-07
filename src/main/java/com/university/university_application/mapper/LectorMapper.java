package com.university.university_application.mapper;

import com.university.university_application.db.entity.LectorEntity;
import com.university.university_application.domain.model.Lector;
import org.springframework.stereotype.Component;
/*
    Consider mapstruck library usage for auto-generation of mappers
 */
@Component
public class LectorMapper {
    public LectorEntity toEntity(Lector lector){
        LectorEntity entity = new LectorEntity();
        entity.setId(lector.getId());
        entity.setFirstName(lector.getFirstName());
        entity.setLastName(lector.getLastName());
        entity.setDegree(lector.getDegree());
        entity.setSalary(lector.getSalary());
        return entity;
    }
    public Lector toDomain(LectorEntity entity){
        Lector lector = new Lector();
        lector.setId(entity.getId());
        lector.setFirstName(entity.getFirstName());
        lector.setLastName(entity.getLastName());
        lector.setDegree(entity.getDegree());
        lector.setSalary(entity.getSalary());
        return lector;
    }
}
