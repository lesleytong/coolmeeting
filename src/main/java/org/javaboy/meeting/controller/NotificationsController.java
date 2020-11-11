package org.javaboy.meeting.controller;

import org.javaboy.meeting.model.Employee;
import org.javaboy.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class NotificationsController {
    @Autowired
    MeetingService meetingService;

    @GetMapping({"/notifications", "/admin/notifications"})
    public String notifications(Model model, HttpSession session){
        Employee currentuser = (Employee) session.getAttribute("currentuser");  // LoginController.java设置了httpSession的当前用户
        model.addAttribute("nos", meetingService.getMbsByEmpId(currentuser.getEmployeeid()));
        return "notifications";
    }
}
