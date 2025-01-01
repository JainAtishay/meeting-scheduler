package com.lld.meeting_scheduler.service.impl;

import com.lld.meeting_scheduler.model.Participant;
import com.lld.meeting_scheduler.service.INotificationService;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements INotificationService {
    @Override
    public void sendNotification(Participant participant, String message) {
        System.out.println(message + " for user : "+ participant.getName());
    }
}
