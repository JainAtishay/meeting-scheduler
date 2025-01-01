package com.lld.meeting_scheduler.service.impl;

import com.lld.meeting_scheduler.model.Meeting;
import com.lld.meeting_scheduler.model.Room;
import com.lld.meeting_scheduler.model.Slot;
import com.lld.meeting_scheduler.service.IRoomManagementService;
import com.lld.meeting_scheduler.service.IRoomMatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class DefaultRoomMatchService implements IRoomMatchService {

    private final IRoomManagementService roomManagementService;

    @Override
    public Room selectRoom(Slot slot) {

        List<Room> allRooms = roomManagementService.getAllRooms();

        for(Room room : allRooms){
            if(isRoomAvailable(room.getScheduledMeetings(), slot)){
                return room;
            }
        }

        return null;
    }

    @Override
    public void removeMeeting(Meeting meeting) {
        Room room = meeting.getRoom();
        room.getScheduledMeetings().remove(meeting);
    }

    @Override
    public void addMeeting(Room selectedRoom, Meeting meeting) {
        roomManagementService.addMeetingInRoom(meeting, selectedRoom);
    }


    private boolean isRoomAvailable(List<Meeting> meetings, Slot slot){
        meetings.sort(Comparator.comparingInt(meeting -> meeting.getSlot().getStartTime()));
        int index = binarySearchOnMeetings(meetings, slot.getStartTime());

        if(index != -1 && meetings.get(index).getSlot().getEndTime() > slot.getStartTime()){
            return false;
        }

        if(index+1 < meetings.size() && meetings.get(index+1).getSlot().getStartTime() < slot.getEndTime()){
            return false;
        }

        return true;
    }

    private int binarySearchOnMeetings(List<Meeting> meetings, int startTime) {

        int low = 0;
        int high = meetings.size()-1;

        while(low <= high){
            int mid = low+ (high-low)/2;
            Slot midMeetingSlot = meetings.get(mid).getSlot();

            if(midMeetingSlot.getEndTime() < startTime){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }

        return high;
    }
}



/*
1-2         5-6         8-10    12-14


11-12*/