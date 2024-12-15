package org.sda.attendance.services;

import org.sda.attendance.models.Attendance;
import org.sda.attendance.repositories.AttendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AttendImpl implements AttendService {

    private final AttendRepository attendRepository;

    @Autowired
    public AttendImpl(AttendRepository attendRepository) {
        this.attendRepository = attendRepository;
    }

    @Override
    public List<Attendance> getAttendances() {
        return attendRepository.findAll();
    }

    @Override
    public void updateAttendance() {
    }

    @Override
    public void createAttendance(Attendance attendance) {
        attendRepository.save(attendance);
    }

    @Override
    public void saveAttendance(Attendance attendance) {
        attendRepository.save(attendance);
    }

    @Override
    public void deleteAttendance(Long Id) {
        Optional<Attendance> attendance = attendRepository.findById(Id);
        if (attendance.isPresent()){
            attendRepository.delete(attendance.get());
        }
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        attendRepository.save(attendance);
    }

    @Override
    public Attendance getAttendById(Long id) {
            return attendRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("Attendance with id " + id + " not found.")
            );
    }

    @Override
    public List<Attendance> getIsPresent() {
        return attendRepository.findAllIsPresent();
    }

    @Override
    public List<Attendance> getAttendanceByDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date, formatter);
        return attendRepository.findAttendanceByDate(date1);
    }

//    @Override
//    public List<Attendance> getAttendanceByName(String name) {
//        return attendRepository.findAttendanceByNameContainsIgnoreCase(name);
//    }


}
