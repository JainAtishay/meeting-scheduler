package com.lld.meeting_scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class MeetingRequest {
    private int meetingNo;
    private List<Participant> participants;
    private Participant host;
    private Slot slot;
    private Room room;
}
