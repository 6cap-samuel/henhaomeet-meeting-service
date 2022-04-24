package samuel.henhaomeet.meetingservice.controllers.mappers;

import org.springframework.stereotype.Component;
import samuel.henhaomeet.meetingservice.controllers.requests.CreateMeetingRequest;
import samuel.henhaomeet.meetingservice.controllers.requests.UpdateMeetingRequest;
import samuel.henhaomeet.meetingservice.controllers.responses.PatchMeetingResponse;
import samuel.henhaomeet.meetingservice.models.Meeting;

@Component
public class RequestToMeetingMapper {
    public Meeting map(CreateMeetingRequest createMeetingRequest){
        return createMeetingRequest.getMeeting();
    }

    public Meeting map(UpdateMeetingRequest updateMeetingRequest) {
        return updateMeetingRequest.getMeeting();
    }
}
