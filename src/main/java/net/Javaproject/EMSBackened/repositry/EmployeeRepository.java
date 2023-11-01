package net.Javaproject.EMSBackened.repositry;

import net.Javaproject.EMSBackened.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee,Long> {
}
