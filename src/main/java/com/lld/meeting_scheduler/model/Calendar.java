package com.lld.meeting_scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Calendar {
    private Participant participant;
    private List<Meeting> meetings;
}
