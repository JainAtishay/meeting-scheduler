package com.lld.meeting_scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Slot {
    private int startTime;
    private int endTime;
}
