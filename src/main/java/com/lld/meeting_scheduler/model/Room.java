package com.lld.meeting_scheduler.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Room {
    private int roomNo;
    private int capacity;
    @JsonManagedReference
    private List<Meeting> scheduledMeetings = new ArrayList<>();
}
