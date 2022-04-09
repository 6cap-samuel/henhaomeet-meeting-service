package samuel.henhaomeet.meetingservice.controllers.requests;

import lombok.Data;
import samuel.henhaomeet.meetingservice.models.Meeting;

@Data
public class UpdateMeetingRequest {
    private Meeting meeting;
}
