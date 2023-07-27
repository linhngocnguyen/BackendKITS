package com.example.projectonetoone.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_Employee")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String Name;
    private String Gender;
    private String Dept;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Id_Sal", referencedColumnName = "ID")
    private EmpSalary emps;
}