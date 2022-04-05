package samuel.henhaomeet.meetingservice.repositories.mappers;

import org.springframework.stereotype.Component;
import samuel.henhaomeet.meetingservice.dtos.ParticipantDto;
import samuel.henhaomeet.meetingservice.models.Participant;

@Component
public class DtoToParticipantMapper {
    public Participant map(ParticipantDto participantDto) {
        return Participant.Factory.build(
                participantDto.getImageUrl(),
                participantDto.getName(),
                participantDto.getStatus()
        );
    }
}
