package com.example.projectonetoone.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_EmpSalary")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private double Salary;
    private double moreSalary;
}
