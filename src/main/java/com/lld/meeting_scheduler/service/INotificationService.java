package com.lld.meeting_scheduler.service;


import com.lld.meeting_scheduler.model.Meeting;
import com.lld.meeting_scheduler.model.Participant;

public interface INotificationService {
    void sendNotification(Participant participant, String message);
}
