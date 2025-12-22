package com.university.university_application.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@EqualsAndHashCode
public class Lector {
    private Long id;
    private String firstName;
    private String lastName;
    private double salary;
}
