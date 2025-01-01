package com.lld.meeting_scheduler.service.impl;

import com.lld.meeting_scheduler.model.Meeting;
import com.lld.meeting_scheduler.model.MeetingRequest;
import com.lld.meeting_scheduler.model.Room;
import com.lld.meeting_scheduler.service.IMeetingService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MeetingService implements IMeetingService {

    private final Map<Integer, Meeting> meetings = new HashMap<>();

    @Override
    public Meeting createMeeting(MeetingRequest meetingRequest, Room room) {
        Meeting meeting = new Meeting(meetingRequest.getMeetingNo(), meetingRequest.getParticipants(), meetingRequest.getHost(), meetingRequest.getSlot(), room);
        meetings.put(meetings.size()+1, meeting);
        return meeting;
    }

    @Override
    public Meeting getMeeting(int meetingNo) {
        return meetings.get(meetingNo);
    }
}
