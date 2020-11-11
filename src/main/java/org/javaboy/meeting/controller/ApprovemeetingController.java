package org.javaboy.meeting.controller;

import org.javaboy.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ApprovemeetingController {

    public static final Integer PENDING_APPROVE = 0;

    @Autowired
    MeetingService meetingService;

    @RequestMapping("/approvemeeting")
    public String approvemeeting(Model model){
        model.addAttribute("meetings", meetingService.getAllMeetingsByStatus(PENDING_APPROVE));
        return "approvemeeting";
    }

    @RequestMapping("/updatestatus2")
    public String updatestatus2(Integer meetingid, Integer status){
        Integer result = meetingService.updatestatus2(meetingid, status);
        return "redirect:/admin/approvemeeting";
    }


}
