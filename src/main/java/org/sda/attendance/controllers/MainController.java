package org.sda.attendance.controllers;

import org.sda.attendance.models.Attendance;
import org.sda.attendance.models.Employee;
import org.sda.attendance.services.AttendService;
import org.sda.attendance.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Objects;

@Controller
public class MainController {

    private final AttendService attendService;
    private final EmployeeService employeeService;
    @Autowired
    public MainController(AttendService attendService, EmployeeService employeeService) {
        this.attendService = attendService;
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getMainPage(Model model,
                              @RequestParam(value = "search", required = false) String search,
                              @RequestParam(value = "sortBy", required = false) String sortBy) {
        model.addAttribute("welcomeString", "Attendance table");
        model.addAttribute("attendances", attendService.getAttendances());
        if (Objects.nonNull(search)) {
            model.addAttribute("attendances", attendService.getAttendanceByEmployee(search));
        } else if
        (Objects.nonNull(sortBy)) {
            model.addAttribute("attendances", attendService.getAllSorted(sortBy));
        }
            return "index";
        }

//
        @GetMapping("/add-attendance")
        public String getAttendanceForm (Model model) {
            model.addAttribute("employees", employeeService.getEmployees());
            return "add-attendance";
        }

        @PostMapping("/add-attendance")
        public String createAttendance (
                @RequestParam Long employeeId,
                @RequestParam String date,
                @RequestParam(required = false, defaultValue = "false") boolean isPresent,
                @RequestParam(required = false, defaultValue = "0") int workedHours){

            Attendance attendance = new Attendance(date, isPresent, workedHours);
            Employee employee = employeeService.getById(employeeId);
            attendance.setEmployee(employee);
            attendService.saveAttendance(attendance);
            return "redirect:/";
        }

        @GetMapping("/delete/{id}")
        public String deleteAttendance (@PathVariable("id") Long Id){
            attendService.deleteAttendance(Id);
            return "redirect:/";
        }

    @GetMapping("/edit-attendance/{id}")
    public String getAttendForm(@PathVariable("id") Long attendOrder, Model model) {
        model.addAttribute("attendance", attendService.getAttendById(attendOrder));
        return "edit-attendance";
    }

        @PostMapping("/edit-attendance/{id}")
        public String createAttend (@PathVariable("id") Long attendOrder,
//                @RequestParam String name,
        @RequestParam(required = false, defaultValue = "false") boolean isPresent,
        @RequestParam float workedHours,
        @RequestParam LocalDate date){
            Attendance a = attendService.getAttendById(attendOrder);
//        a.setName(name);
            a.setPresent(isPresent);
            a.setWorkedHours(workedHours);
            a.setDate(date);

            attendService.updateAttendance(a);
            return "redirect:/";
        }
//
        @GetMapping("/attend-detail/{attendance}")
        public String showDetails (@PathVariable("attendance") Long attendOrder, Model model){
            model.addAttribute("attendance", attendService.getAttendById(attendOrder));
            return "attend-detail";
        }
////
        @GetMapping("/present")
        public String showPresent (Model model){
            model.addAttribute("attendances", attendService.getIsPresent());
            return "present";
        }
        @GetMapping("/attend-by-date")
        public String searchAttendByDate (Model model, @RequestParam(value = "search", required = false) String search){
            model.addAttribute("welcomeString", "Attendace table");
            if (Objects.nonNull(search)) {
                model.addAttribute("attendances", attendService.getAttendanceByDate(search));
            } else {
                model.addAttribute("attendances", attendService.getAttendances());
            }
            return "attend-by-date";
        }
//
//    }
    }

