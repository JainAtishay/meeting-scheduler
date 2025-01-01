package com.lld.meeting_scheduler.service;

import com.lld.meeting_scheduler.model.Meeting;
import com.lld.meeting_scheduler.model.MeetingRequest;
import com.lld.meeting_scheduler.model.Participant;
import com.lld.meeting_scheduler.model.Room;

public interface IParticipantService {
    Participant addParticipant(Participant participant);
    void addMeeting(Meeting meeting, Participant participant);

    void removeMeeting(Meeting meeting, Participant participant);
}
