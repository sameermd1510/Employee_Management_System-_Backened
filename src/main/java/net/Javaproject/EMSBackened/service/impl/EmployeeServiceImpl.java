package net.Javaproject.EMSBackened.service.impl;

import lombok.AllArgsConstructor;
import net.Javaproject.EMSBackened.dto.EmployeeDto;
import net.Javaproject.EMSBackened.entity.Employee;
import net.Javaproject.EMSBackened.mapper.EmployeeMapper;
import net.Javaproject.EMSBackened.repositry.EmployeeRepository;
import net.Javaproject.EMSBackened.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee save = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(save);
    }

    @Override
    public EmployeeDto getEmployeeByID(Long employeeId) {


        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->new RuntimeException("Employee is Not Exists with Given ID :"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->new RuntimeException("Employees not Found By Given id :"+employeeId));

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->new RuntimeException("Employees not Found By Given id :"+employeeId));

        employeeRepository.deleteById(employeeId);
    }
}
