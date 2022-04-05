package samuel.henhaomeet.meetingservice.repositories.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import samuel.henhaomeet.meetingservice.dtos.MeetingDto;
import samuel.henhaomeet.meetingservice.models.Meeting;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MeetingToDtoMapper {

    private final ParticipantToDtoMapper participantToDtoMapper;

    public MeetingDto map(Meeting meeting) {
        return MeetingDto.Factory.build(
                meeting.getId(),
                meeting.getTitle(),
                meeting.getDescription(),
                meeting.getLocation(),
                meeting.getDateTime(),
                meeting.getParticipantSet()
                        .stream()
                        .map(participantToDtoMapper::map)
                        .collect(Collectors.toSet())
        );
    }
}
