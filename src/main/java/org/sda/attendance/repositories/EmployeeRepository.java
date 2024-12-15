package org.sda.attendance.repositories;

import org.sda.attendance.models.Attendance;
import org.sda.attendance.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
