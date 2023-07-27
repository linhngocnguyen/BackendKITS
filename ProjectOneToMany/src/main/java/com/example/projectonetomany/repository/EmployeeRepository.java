package com.example.projectonetomany.repository;

import com.example.projectonetomany.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.Province LIKE %:province%")
    List<Employee> findByProvince(@Param("province") String province);

    @Query("SELECT e FROM Employee e WHERE e.Province LIKE %:province% AND e.Gender LIKE %:gender%")
    List<Employee> findByProvinceAndGender(@Param("province") String province, @Param("gender")String gender);
}
