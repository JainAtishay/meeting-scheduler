package com.lld.meeting_scheduler.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Meeting {
    private int meetingNo;
    private List<Participant> participants;
    private Participant host;
    private Slot slot;
    @JsonManagedReference
    private Room room;
}
