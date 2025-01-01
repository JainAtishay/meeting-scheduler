package com.lld.meeting_scheduler.service.impl;

import com.lld.meeting_scheduler.model.Calendar;
import com.lld.meeting_scheduler.model.Meeting;
import com.lld.meeting_scheduler.model.Participant;
import com.lld.meeting_scheduler.service.IParticipantService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ParticipantService implements IParticipantService {
    private Map<Integer, Participant> participantMap = new HashMap<>();
    private Map<Participant, Calendar> participantCalendarMap = new HashMap<>();

    @Override
    public Participant addParticipant(Participant participant) {
        participantMap.put(participantMap.size()+1, participant);
        participantCalendarMap.put(participant, new Calendar());
        return participant;
    }

    @Override
    public void addMeeting(Meeting meeting, Participant participant) {
        List<Meeting> participantMeetings = participantCalendarMap.get(participant).getMeetings();

        if(CollectionUtils.isEmpty(participantMeetings)){
            participantMeetings = new ArrayList<>();
        }

        participantMeetings.add(meeting);
    }

    @Override
    public void removeMeeting(Meeting meeting, Participant participant) {
        participantCalendarMap.get(participant).getMeetings().remove(meeting);
    }
}
