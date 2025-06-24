package com.guide.erp.service.impl;

import org.springframework.stereotype.Service;

import com.guide.erp.dto.EmployeeDto;
import com.guide.erp.entity.Employee;
import com.guide.erp.mapper.EmployeeMapper;
import com.guide.erp.repository.EmployeeRepository;
import com.guide.erp.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServicesImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        
        Employee employee = EmployeeMapper.mapDtoToEmployee(employeeDto);
        employee = employeeRepository.save(employee);
        return EmployeeMapper.mapEmployeeToDto(employee);
    }
}
