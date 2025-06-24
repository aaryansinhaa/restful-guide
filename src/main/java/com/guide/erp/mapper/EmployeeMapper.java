package com.guide.erp.mapper;

import com.guide.erp.dto.EmployeeDto;
import com.guide.erp.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapEmployeeToDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDto dto = new EmployeeDto();
        dto.setEmpId(employee.getEmpId());
        dto.setEmpName(employee.getEmpName());
        dto.setEmpEmail(employee.getEmpEmail());
        dto.setEmpPhone(employee.getEmpPhone());
        dto.setEmpAddress(employee.getEmpAddress());
        dto.setEmpPosition(employee.getEmpPosition());
        dto.setEmpSalary(employee.getEmpSalary());
        dto.setEmpDepartment(employee.getEmpDepartment());
        dto.setEmpHireDate(employee.getEmpHireDate());
        if (employee.getManager() != null) {
            dto.setManagerId(employee.getManager().getEmpId());
        }
        return dto;
    }

    public static Employee mapDtoToEmployee(EmployeeDto dto) {
        if (dto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setEmpId(dto.getEmpId());
        employee.setEmpName(dto.getEmpName());
        employee.setEmpEmail(dto.getEmpEmail());
        employee.setEmpPhone(dto.getEmpPhone());
        employee.setEmpAddress(dto.getEmpAddress());
        employee.setEmpPosition(dto.getEmpPosition());
        employee.setEmpSalary(dto.getEmpSalary());
        employee.setEmpDepartment(dto.getEmpDepartment());
        employee.setEmpHireDate(dto.getEmpHireDate());
        if (dto.getManagerId() != null) {
        Employee manager = new Employee();
        manager.setEmpId(dto.getManagerId());
        employee.setManager(manager);
        } else {
            employee.setManager(null);
        }
        return employee;
    }
}
