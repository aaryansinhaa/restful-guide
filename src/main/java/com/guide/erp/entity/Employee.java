package com.guide.erp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")   
    private Long empId;
    @Column(name = "emp_name", nullable = false)
    private String empName;
    @Column(name = "emp_email", nullable = false, unique = true)
    private String empEmail;
    @Column(name = "emp_phone", nullable = false, unique = true)
    private String empPhone;
    @Column(name = "emp_address", nullable = false)
    private String empAddress;
    @Column(name = "emp_position", nullable = false)
    private String empPosition;
    @Column(name = "emp_salary", nullable = false)
    private double empSalary;
    @Column(name = "emp_department", nullable = false)
    private String empDepartment;
    @Column(name = "emp_hire_date", nullable = false)
    private LocalDate empHireDate;
    @ManyToOne
    @JoinColumn(name = "emp_manager")
    private Employee manager;

}
