package net.Javaproject.EMSBackened.controller;

import lombok.AllArgsConstructor;
import net.Javaproject.EMSBackened.dto.EmployeeDto;
import net.Javaproject.EMSBackened.entity.Employee;
import net.Javaproject.EMSBackened.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping( "/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    // Build Add Employee Rest Api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);

    }

    //Build Get Employee REST Api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeByID(@PathVariable("id") Long employee){
        EmployeeDto employeeDto =employeeService.getEmployeeByID(employee);
        return ResponseEntity.ok(employeeDto);
    }

    // Build Get AllEmployee Rest Api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees=employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeID,
                                                      @RequestBody EmployeeDto updateEmployee){
        EmployeeDto employeeDto=employeeService.updateEmployee(employeeID,updateEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted Succefully!");
    }
}
