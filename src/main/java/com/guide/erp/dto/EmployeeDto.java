package com.guide.erp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long empId;
    private String empName;
    private String empEmail;
    private String empPhone;
    private String empAddress;
    private String empPosition;
    private double empSalary;
    private String empDepartment;
    private LocalDate empHireDate;
    private Long managerId;
}
