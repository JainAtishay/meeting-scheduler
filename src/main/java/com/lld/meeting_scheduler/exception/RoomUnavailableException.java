package com.lld.meeting_scheduler.exception;

public class RoomUnavailableException extends RuntimeException {
    public RoomUnavailableException(String message){
        super(message);
    }
}
