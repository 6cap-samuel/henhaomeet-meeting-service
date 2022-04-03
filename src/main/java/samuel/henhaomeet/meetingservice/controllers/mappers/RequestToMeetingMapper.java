package samuel.henhaomeet.meetingservice.controllers.mappers;

import org.springframework.stereotype.Component;
import samuel.henhaomeet.meetingservice.controllers.requests.CreateMeetingRequest;
import samuel.henhaomeet.meetingservice.models.Meeting;

@Component
public class RequestToMeetingMapper {
    public Meeting map(CreateMeetingRequest createMeetingRequest){
        return createMeetingRequest.getMeeting();
    }
}
