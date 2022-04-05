package samuel.henhaomeet.meetingservice.controllers.requests;

import lombok.Data;
import samuel.henhaomeet.meetingservice.models.Participant;

@Data
public class AddParticipantRequest {
    private Participant participant;
}
