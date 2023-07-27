package com.example.projectonetomany.service;

import com.example.projectonetomany.model.Employee;
import com.example.projectonetomany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeByID(int ID){
        return employeeRepository.findById(ID);
    }

    public List<Employee> getByProvince(String province) {
        return employeeRepository.findByProvince(province);
    }

    public List<Employee> getByProvinceAndGender(String province, String gender) {
        return employeeRepository.findByProvinceAndGender(province, gender);
    }


    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> saveEmployees(List<Employee> employees){
        employeeRepository.saveAll(employees);
        return employees;
    }

    public Employee updateEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getID());
        if (existingEmployee.isPresent()){
            employeeRepository.save(existingEmployee);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found");
        }
    }
}
