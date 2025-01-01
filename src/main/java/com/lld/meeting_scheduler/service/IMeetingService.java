package com.lld.meeting_scheduler.service;

import com.lld.meeting_scheduler.model.Meeting;
import com.lld.meeting_scheduler.model.MeetingRequest;
import com.lld.meeting_scheduler.model.Room;
import com.lld.meeting_scheduler.model.Slot;

public interface IMeetingService {
    Meeting createMeeting(MeetingRequest meetingRequest, Room room);
    Meeting getMeeting(int meetingNo);
}
