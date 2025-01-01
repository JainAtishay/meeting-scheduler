package com.lld.meeting_scheduler;

import com.lld.meeting_scheduler.model.*;
import com.lld.meeting_scheduler.service.*;
import com.lld.meeting_scheduler.service.impl.*;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class MeetingSchedulerTest {

    public static void main(String[] args) {
        RoomManagementService roomManagementService = new RoomManagementService();
        Room room1 = new Room(1,4 , new ArrayList<>());
        Room room2 = new Room(2,4 , new ArrayList<>());
        roomManagementService.addRoom(room1);
        roomManagementService.addRoom(room2);

        ParticipantService participantService = new ParticipantService();
        Participant participant1 = new Participant("atishay");
        Participant participant2 = new Participant("gulu");
        List<Participant> participantList = new ArrayList<>(Arrays.asList(participant1, participant2));
        participantService.addParticipant(participant1);
        participantService.addParticipant(participant2);

        MeetingRequest meetingRequest1 = new MeetingRequest(1, participantList, participant1, new Slot(1, 2), room1);
        MeetingRequest meetingRequest2 = new MeetingRequest(2, participantList, participant1, new Slot(5, 7), room1);
        MeetingRequest meetingRequest3 = new MeetingRequest(3, participantList, participant1, new Slot(5, 7), room1);
        MeetingRequest meetingRequest4 = new MeetingRequest(4, participantList, participant1, new Slot(3, 4), room1);
        MeetingRequest meetingRequest5 = new MeetingRequest(5, participantList, participant1, new Slot(4, 6), room1);

        IRoomMatchService roomMatchService = new DefaultRoomMatchService(roomManagementService);
        IMeetingService meetingService = new MeetingService();
        INotificationService notificationService = new EmailNotificationService();

        MeetingScheduler meetingScheduler =new MeetingScheduler(roomMatchService, meetingService, participantService, notificationService);
        Meeting meeting1 = meetingScheduler.scheduleMeeting(meetingRequest1);
        Meeting meeting2 = meetingScheduler.scheduleMeeting(meetingRequest2);
        Meeting meeting3 = meetingScheduler.scheduleMeeting(meetingRequest3);
        Meeting meeting4 = meetingScheduler.scheduleMeeting(meetingRequest4);
        Meeting meeting5 = meetingScheduler.scheduleMeeting(meetingRequest5);


        System.out.println("meeting 1 room  : "+meeting1.getRoom().getRoomNo());
        System.out.println("meeting 2 room  : "+meeting2.getRoom().getRoomNo());
        System.out.println("meeting 3 room  : "+meeting3.getRoom().getRoomNo());
        System.out.println("meeting 4 room  : "+meeting4.getRoom().getRoomNo());
        System.out.println("meeting 5 room  : "+meeting5.getRoom().getRoomNo());
    }
}
