package org.sda.attendance.services;

import org.sda.attendance.models.Attendance;
import org.sda.attendance.models.Employee;

import java.util.List;

public interface AttendService {

    public List <Attendance> getAttendances();

    public void updateAttendance();

    void createAttendance(Attendance attendance);

    void saveAttendance (Attendance attendance);

    void deleteAttendance(Long id);

    void updateAttendance(Attendance attendance);

    Attendance getAttendById(Long id);

    List<Attendance> getIsPresent();

    List<Attendance> getAttendanceByDate(String date);

    List<Attendance> getAttendanceByEmployee(String search);

    List<Attendance> getAllSorted(String parameter);

//    List<Attendance> getAttendanceByName(String lastName);
}
