package org.javaboy.meeting.service;

import org.javaboy.meeting.mapper.MeetingMapper;
import org.javaboy.meeting.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MeetingService {

    @Autowired
    MeetingMapper meetingMapper;

    public Integer addMeeting(Meeting meeting, Integer[] mps) {
        meeting.setReservationtime(new Date());
        Integer result = meetingMapper.addMeeting(meeting);
        meetingMapper.addParticipants(meeting.getMeetingid(), mps);
        return result;
    }

    public List<Meeting> getAllMeetingsByStatus(Integer status) {
        return meetingMapper.getAllMeetingsByStatus(status);
    }

    public Integer updatestatus2(Integer meetingid, Integer status) {
        return meetingMapper.updatestatus2(meetingid, status);
    }


    public List<Meeting> getMbsByEmpId(Integer reservationistid) {
        return meetingMapper.getMbsByEmpId(reservationistid);
    }
}
