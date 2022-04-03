package samuel.henhaomeet.meetingservice.controllers.requests;

import lombok.Data;
import samuel.henhaomeet.meetingservice.models.Meeting;

@Data
public class CreateMeetingRequest {
    private Meeting meeting;
}
