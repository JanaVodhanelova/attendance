package org.sda.attendance;

import org.sda.attendance.models.Attendance;
import org.sda.attendance.models.Employee;
import org.sda.attendance.repositories.AttendRepository;
import org.sda.attendance.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AttendanceApplication implements CommandLineRunner {

	private final AttendRepository attendRepository;
	private final EmployeeRepository employeeRepository;

	@Autowired
    public AttendanceApplication(AttendRepository attendRepository, EmployeeRepository employeeRepository) {
        this.attendRepository = attendRepository;
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Employee> employees = new ArrayList<>(List.of(
				new Employee("Pepa", "Vomáčka", "kuchař"),
				new Employee("Béďa", "Trávníček", "zahradník"),
				new Employee("Tonda", "Sklenička", "číšník")
		));



		List<Attendance> attendances = new ArrayList<>(List.of(
				new Attendance("10-10-2024", true, 8),
				new Attendance("10-10-2024", false, 0),
				new Attendance("10-10-2024", true, 6),
				new Attendance("11-10-2024", true, 8),
				new Attendance("11-10-2024", true, 2),
				new Attendance("11-10-2024", false, 0),
				new Attendance("12-10-2024", false, 0),
				new Attendance("12-10-2024", true, 6),
				new Attendance("12-10-2024", true, 8),
				new Attendance("13-10-2024", true, 8),
				new Attendance("13-10-2024", true, 8),
				new Attendance("13-10-2024", true, 8),
				new Attendance("14-10-2024", false, 0),
				new Attendance("14-10-2024", false, 0),
				new Attendance("14-10-2024", false, 0)
		));



		attendances.get(0).setEmployee(employees.get(0));
		attendances.get(1).setEmployee(employees.get(1));
		attendances.get(2).setEmployee(employees.get(2));
		attendances.get(3).setEmployee(employees.get(0));
		attendances.get(4).setEmployee(employees.get(1));
		attendances.get(5).setEmployee(employees.get(2));
		attendances.get(6).setEmployee(employees.get(0));
		attendances.get(7).setEmployee(employees.get(1));
		attendances.get(8).setEmployee(employees.get(2));
		attendances.get(9).setEmployee(employees.get(0));
		attendances.get(10).setEmployee(employees.get(1));
		attendances.get(11).setEmployee(employees.get(2));
		attendances.get(12).setEmployee(employees.get(0));
		attendances.get(13).setEmployee(employees.get(1));
		attendances.get(14).setEmployee(employees.get(2));

		for (Employee employee : employees){
			employeeRepository.save(employee);
		}

		for (Attendance attendance : attendances){
			attendRepository.save(attendance);
		}

	}
}
