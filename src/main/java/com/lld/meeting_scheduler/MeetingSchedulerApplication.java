package com.lld.meeting_scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * Requirements
 * 1. User should be able to schedule a meeting for any time and date
 * 2. Room should be selected based on availability of requested time slot
 * 3. Scheduled meeting should be added to user calendar
 * 4. Notification should be triggered to user for schedule meeting details
 * 5. User should be able to cancel a schedule meeting
 */

@SpringBootApplication
public class MeetingSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingSchedulerApplication.class, args);
	}

}

