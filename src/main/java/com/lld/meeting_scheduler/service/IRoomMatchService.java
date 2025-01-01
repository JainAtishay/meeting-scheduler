package com.lld.meeting_scheduler.service;

import com.lld.meeting_scheduler.model.Meeting;
import com.lld.meeting_scheduler.model.Room;
import com.lld.meeting_scheduler.model.Slot;

public interface IRoomMatchService {
    Room selectRoom(Slot slot);
    void removeMeeting(Meeting meeting);
    void addMeeting(Room selectedRoom, Meeting meeting);
}
