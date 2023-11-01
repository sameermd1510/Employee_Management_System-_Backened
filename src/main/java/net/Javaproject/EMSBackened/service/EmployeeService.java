package net.Javaproject.EMSBackened.service;

import net.Javaproject.EMSBackened.dto.EmployeeDto;
import java.util.*;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeByID(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeID);
}
