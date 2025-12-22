package com.university.university_application.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter @Setter
public class DepartmentEntity {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "head_of_department_name")
    private String headName;
}
