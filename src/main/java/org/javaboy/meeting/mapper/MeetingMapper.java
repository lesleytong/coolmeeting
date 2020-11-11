package org.javaboy.meeting.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.meeting.model.Meeting;

import java.util.List;

public interface MeetingMapper {
    Integer addMeeting(Meeting meeting);

    void addParticipants(@Param("meetingid") Integer meetingid, @Param("mps") Integer[] mps);

    List<Meeting> getAllMeetingsByStatus(Integer status);

    Integer updatestatus2(@Param("meetingid") Integer meetingid, @Param("status") Integer status);


    List<Meeting> getMbsByEmpId(Integer reservationistid);
}
