package com.lld.meeting_scheduler.service.impl;

import com.lld.meeting_scheduler.exception.RoomUnavailableException;
import com.lld.meeting_scheduler.model.*;
import com.lld.meeting_scheduler.service.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class MeetingScheduler {
    private final IRoomMatchService roomMatchService;
    private final IMeetingService meetingService;
    private final IParticipantService participantService;
    private final INotificationService notificationService;

    public Meeting scheduleMeeting(MeetingRequest meetingRequest){
        Slot requestedSlot = meetingRequest.getSlot();
        Room selectedRoom = roomMatchService.selectRoom(requestedSlot);

        if(selectedRoom == null){
            throw new RoomUnavailableException("No room available");
        }

        Meeting meeting = meetingService.createMeeting(meetingRequest, selectedRoom);

        roomMatchService.addMeeting(selectedRoom, meeting);

        List<Participant> participantList = meetingRequest.getParticipants();

        String notificationMessage = getNotificationMessage(meeting);

        List<CompletableFuture<Void>> futures = participantList.stream().map(participant -> CompletableFuture.runAsync(() -> {
            participantService.addMeeting(meeting, participant);
            notificationService.sendNotification(participant, notificationMessage);
        })).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return meeting;
    }

    public void cancelMeeting(Meeting meeting){
        roomMatchService.removeMeeting(meeting);
        List<Participant> participantList = meeting.getParticipants();
        String notificationMessage = "meeting cancelled";

        List<CompletableFuture<Void>> futures = participantList.stream().map(participant -> CompletableFuture.runAsync(() -> {
            participantService.removeMeeting(meeting, participant);
            notificationService.sendNotification(participant, notificationMessage);
        })).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }

    private String getNotificationMessage(Meeting meeting) {
        return "you have been invited for meeting";
    }
}

/*
Schedule meeting
room service
1. Request -> list of participants, Slot
1. get select room -> room Match service
2. Create a meeting if room is available -> meeting service
3. Add meeting to user calendar -> participantService
4. send async notification to all participants -> notification service
 */