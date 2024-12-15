package org.sda.attendance.services;


import org.sda.attendance.models.Employee;
import org.sda.attendance.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
