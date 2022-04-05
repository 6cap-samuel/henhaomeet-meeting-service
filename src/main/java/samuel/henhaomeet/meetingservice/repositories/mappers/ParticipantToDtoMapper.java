package samuel.henhaomeet.meetingservice.repositories.mappers;

import org.springframework.stereotype.Component;
import samuel.henhaomeet.meetingservice.dtos.ParticipantDto;
import samuel.henhaomeet.meetingservice.models.Participant;

@Component
public class ParticipantToDtoMapper {
    public ParticipantDto map(Participant participant) {
        return ParticipantDto.Factory.build(
                participant.getImageUrl(),
                participant.getName(),
                participant.getStatus()
        );
    }
}
