package samuel.henhaomeet.meetingservice.controllers.mappers;

import org.springframework.stereotype.Component;
import samuel.henhaomeet.meetingservice.controllers.requests.AddParticipantRequest;
import samuel.henhaomeet.meetingservice.controllers.requests.PatchParticipantRequest;
import samuel.henhaomeet.meetingservice.models.Participant;

@Component
public class RequestToParticipantMapper {
    public Participant map(AddParticipantRequest addParticipantRequest){
        return addParticipantRequest.getParticipant();
    }

    public Participant map(PatchParticipantRequest patchParticipantRequest) {
        return patchParticipantRequest.getParticipant();
    }
}
