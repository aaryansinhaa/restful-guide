package com.guide.erp.service.impl;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.guide.erp.dto.EmployeeDto;
import com.guide.erp.entity.Employee;
import com.guide.erp.exception.ResourceNotFoundException;
import com.guide.erp.mapper.EmployeeMapper;
import com.guide.erp.repository.EmployeeRepository;
import com.guide.erp.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServicesImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapDtoToEmployee(employeeDto);
        employee = employeeRepository.save(employee);
        return EmployeeMapper.mapEmployeeToDto(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id: " + id));
        return EmployeeMapper.mapEmployeeToDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        Stream<EmployeeDto> employeeDtoStream = employeeList.stream()
                .map(EmployeeMapper::mapEmployeeToDto);
        /*
         * explanation on what happens here:
         * 1. `employeeList.stream()` creates a stream of Employee objects.
         * 2. `.map(EmployeeMapper::mapEmployeeToDto)` applies the `mapEmployeeToDto`
         * method from `EmployeeMapper` to each Employee object in the stream,
         * converting it to an EmployeeDto.
         * 3. The result is a Stream<EmployeeDto> containing the converted EmployeeDto
         * objects.
         * 4. Finally, `.toList()` collects the EmployeeDto objects into a List<Employee>
         * 
         * Why did it not use `collect(Collectors.toList())`?
         * The `toList()` method is a terminal operation that collects the elements of
         * the stream into a List. It is a more concise way to collect the results
         * compared to using `collect(Collectors.toList())`, which is more verbose. The
         * `toList()` method is available in Java 16 and later, providing a more
         * straightforward way to collect stream elements into a list without needing to
         * import the `Collectors` class. This approach is more readable and concise,
         * making it easier to understand the intent of the code.
         * 
         */
        return employeeDtoStream.toList();
    }
}
