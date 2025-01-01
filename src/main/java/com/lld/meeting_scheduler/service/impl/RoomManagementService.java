package com.lld.meeting_scheduler.service.impl;

import com.lld.meeting_scheduler.model.Meeting;
import com.lld.meeting_scheduler.model.Participant;
import com.lld.meeting_scheduler.model.Room;
import com.lld.meeting_scheduler.model.Slot;
import com.lld.meeting_scheduler.service.IRoomManagementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class RoomManagementService implements IRoomManagementService {

    private final Map<Integer, Room> roomMap = new HashMap<>();

    @Override
    public void addRoom(Room room){
        roomMap.put(room.getRoomNo(), room);
    }

    @Override
    public List<Room> getAllRooms() {
        return new ArrayList<>(roomMap.values());
    }

    @Override
    public void addMeetingInRoom(Meeting meeting, Room room) {
        List<Meeting> scheduledMeetings = room.getScheduledMeetings();
        scheduledMeetings.add(meeting);
        room.setScheduledMeetings(scheduledMeetings);
    }
}
