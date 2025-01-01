package com.lld.meeting_scheduler.service;

import com.lld.meeting_scheduler.model.Meeting;
import com.lld.meeting_scheduler.model.MeetingRequest;
import com.lld.meeting_scheduler.model.Room;
import com.lld.meeting_scheduler.model.Slot;

import java.util.List;

public interface IRoomManagementService {
    void addRoom(Room room);
    List<Room> getAllRooms();
    void addMeetingInRoom(Meeting meeting, Room room);
}
