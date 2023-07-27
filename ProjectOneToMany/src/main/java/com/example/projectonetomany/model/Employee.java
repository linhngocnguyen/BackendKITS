package com.example.projectonetomany.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name="tb_Employee")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String Name;
    private String Gender;
    private String Province;
    private double Salary;
}
