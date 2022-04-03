package samuel.henhaomeet.meetingservice.controllers.mappers;

import org.springframework.stereotype.Component;
import samuel.henhaomeet.meetingservice.controllers.responses.CreateMeetingResponse;
import samuel.henhaomeet.meetingservice.models.Meeting;

@Component
public class MeetingToResponseMapper {
    public CreateMeetingResponse map(Meeting meeting){
        return CreateMeetingResponse.Factory.build(meeting);
    }
}
