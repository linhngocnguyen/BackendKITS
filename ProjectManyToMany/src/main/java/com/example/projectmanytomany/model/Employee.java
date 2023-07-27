package com.example.projectmanytomany.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Table (name="tb_Employee")
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Emp_Skill",
            joinColumns = @JoinColumn(name = "IDEmp", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "IDSkill", referencedColumnName = "ID")
    )
    private Set<Skill> skills = new HashSet<>();
}
