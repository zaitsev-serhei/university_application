package com.university.university_application.domain.model;

import com.university.university_application.common.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@EqualsAndHashCode
public class Lector {
    private Long id;
    private String firstName;
    private String lastName;
    private Degree degree;
    private BigDecimal salary;
}
