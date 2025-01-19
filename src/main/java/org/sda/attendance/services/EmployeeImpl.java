package org.sda.attendance.services;


import org.sda.attendance.models.Employee;
import org.sda.attendance.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
    }


//    @Override
//    public List<Employee> findByName(String search) {
//        return employeeRepository.findEmployeeByLastNameAndFirstNameContainsIgnoreCase(search);
//    }
}
