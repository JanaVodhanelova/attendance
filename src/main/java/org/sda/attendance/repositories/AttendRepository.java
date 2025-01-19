package org.sda.attendance.repositories;

import org.sda.attendance.models.Attendance;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendRepository extends JpaRepository<Attendance, Long> {

    @Query(value = "SELECT * from attendance WHERE is_present = true", nativeQuery = true)
    List<Attendance> findAllIsPresent();

    @Query(value = "SELECT * from attendance WHERE date = :date", nativeQuery = true)
    List<Attendance> findAttendanceByDate(@Param("date") LocalDate d);


    List<Attendance> findAttendancesByEmployee_FirstNameContainsIgnoreCaseOrEmployee_LastNameContainsIgnoreCase(String s, String s2);



//    List<Attendance> findAllSorted(String parameter);


}
