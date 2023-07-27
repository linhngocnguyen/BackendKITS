package com.example.projectonetomany.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name="tb_Department")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String DeptName;
    private String Location;
    private String Manager;

    private String deptID;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="deptID", referencedColumnName = "deptID")
    private Set<Employee> emps = new HashSet<>();

}
