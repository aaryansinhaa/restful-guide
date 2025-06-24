package com.guide.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guide.erp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    

}
