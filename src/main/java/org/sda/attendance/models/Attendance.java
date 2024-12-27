package org.sda.attendance.models;

import jakarta.persistence.*;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Entity
@Table(name = "attendance")
public class Attendance extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "is_present")
    private boolean isPresent;

    @Column(name = "worked_hours", columnDefinition = "int default 0")
    private float workedHours;

    public Attendance(String date, boolean isPresent, float workedHours) {
//        this.name = name;
        this.date = dateFromString(date);
        this.isPresent = isPresent;
        this.workedHours = workedHours;
    }

    private LocalDate dateFromString(String string){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateInput = LocalDate.parse(string , formatter);
        return dateInput;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Attendance() {
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public float getWorkedHours() {
        return workedHours;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setPresent(boolean present) {
        isPresent = present;
    }

    public void setWorkedHours(float workedHours) {
        this.workedHours = workedHours;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                ", date=" + date +
                ", isPresent=" + isPresent +
                ", workedHours=" + workedHours +
                '}';
    }
}
