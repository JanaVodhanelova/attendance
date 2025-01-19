package org.sda.attendance.services;

import org.sda.attendance.models.Employee;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getById(Long id);

//    List<Employee> findByName(String search);
}
