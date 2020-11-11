package org.javaboy.meeting.controller;

import org.javaboy.meeting.model.Department;
import org.javaboy.meeting.model.Employee;
import org.javaboy.meeting.model.Meeting;
import org.javaboy.meeting.service.DepartmentService;
import org.javaboy.meeting.service.EmployeeService;
import org.javaboy.meeting.service.MeetingRoomService;
import org.javaboy.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MeetingController {

    @Autowired
    MeetingRoomService meetingRoomService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MeetingService meetingService;

    @RequestMapping({"/bookmeeting", "/admin/bookmeeting"})
    public String bookmeeting(Model model){
        model.addAttribute("mrs", meetingRoomService.getAllMr());
        return "bookmeeting";
    }

    @RequestMapping("/alldeps")
    @ResponseBody
    public List<Department> getAllDeps(){
        return departmentService.getAllDeps();
    }

    @RequestMapping("/getempbydepid")
    @ResponseBody
    public List<Employee> getEmpsByDepId(Integer depId){
        return employeeService.getEmpsByDepId(depId);
    }

    @RequestMapping("/doAddMeeting")
    public String doAddMeeting(Meeting meeting, Integer[] mps, HttpSession session){
       Employee currentuser = (Employee) session.getAttribute("currentuser");
       meeting.setReservationistid(currentuser.getEmployeeid());
       meeting.setStatus(0); // 添加会议后，就是待审批的状态
       Integer result = meetingService.addMeeting(meeting, mps);
       if(result == 1){
           return "redirect:/searchmeetings";
       }else{
           return "forward:/bookmeeting";
       }
    }

    @RequestMapping({"/searchmeetings", "/admin/searchmeetings"})
    public String searchmeetings(){
        return "searchmeetings";
    }

    @RequestMapping({"/mybookings", "/admin/mybookings"})
    public String mybookings(Model model, HttpSession session){
        Employee currentuser = (Employee) session.getAttribute("currentuser");  // LoginController.java设置了httpSession的当前用户
        model.addAttribute("mbs", meetingService.getMbsByEmpId(currentuser.getEmployeeid()));
        return "mybookings";
    }

    @RequestMapping({"/mymeetings", "/admin/mymeetings"})
    public String mymeetings(Model model, HttpSession session){
        Employee currentuser = (Employee) session.getAttribute("currentuser");  // LoginController.java设置了httpSession的当前用户
        model.addAttribute("mes", meetingService.getMbsByEmpId(currentuser.getEmployeeid()));
        return "mymeetings";
    }


}