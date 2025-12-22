package com.university.university_application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString
public class Department {
    private Long id;
    private String name;
    private String headName;
    private Set<Lector> employees;

    public Department(Long id, String name, String headName) {
        this.id = id;
        this.name = name;
        this.headName = headName;
        this.employees = new HashSet();
    }
}
