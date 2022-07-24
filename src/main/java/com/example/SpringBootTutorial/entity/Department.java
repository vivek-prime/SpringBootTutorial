package com.example.SpringBootTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @Column(nullable = false)
    private Long deptId;

    @NotNull(message = "Department name is null, Plz add it.")
    @NotBlank(message = "Department name is blank, Plz add it.")
    // when we add constraints we need to annotate with @Valid in controller
    private String deptName;
    private String deptAddress;
    private String deptCode;
}
