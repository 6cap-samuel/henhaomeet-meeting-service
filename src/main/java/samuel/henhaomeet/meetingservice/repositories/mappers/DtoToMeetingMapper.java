package samuel.henhaomeet.meetingservice.repositories.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import samuel.henhaomeet.meetingservice.dtos.MeetingDto;
import samuel.henhaomeet.meetingservice.models.Meeting;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DtoToMeetingMapper {

    final DtoToParticipantMapper dtoToParticipantMapper;

    public Meeting map(MeetingDto meetingDto) {
        return Meeting.Factory.build(
                meetingDto.getId(),
                meetingDto.getTitle(),
                meetingDto.getDescription(),
                meetingDto.getLocation(),
                meetingDto.getDateTime(),
                meetingDto.getParticipants()
                        .stream()
                        .map(dtoToParticipantMapper::map)
                        .collect(Collectors.toSet())
        );
    }
}
