package com.example.projectonetomany.controller;

import com.example.projectonetomany.model.Employee;
import com.example.projectonetomany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{ID}")
    public Optional<Employee> getEmployeeByID(@PathVariable int ID){
        return employeeService.findEmployeeByID(ID);
    }

    @GetMapping("/province")
    public List<Employee> getEmployeeByProvince(@RequestParam String Province){
        return employeeService.getByProvince(Province);
    }

    @GetMapping("/province-and-gender")
    public List<Employee> getEmployeeByProvinceAndGender(@RequestParam String Province, @RequestParam String Gender){
        return employeeService.getByProvinceAndGender(Province, Gender);
    }

    @PostMapping("/insertEmployee")
    public int insertEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee.getID();
    }

    @PostMapping("/insertEmployees")
    public List<Employee> insertEmployee(@RequestBody List<Employee> employees){
        return employeeService.saveEmployees(employees);
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
}