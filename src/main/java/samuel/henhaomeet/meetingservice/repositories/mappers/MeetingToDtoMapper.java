package samuel.henhaomeet.meetingservice.repositories.mappers;

import org.springframework.stereotype.Component;
import samuel.henhaomeet.meetingservice.dtos.MeetingDto;
import samuel.henhaomeet.meetingservice.models.Meeting;

@Component
public class MeetingToDtoMapper {
    public MeetingDto map(Meeting meeting) {
        return MeetingDto.Factory.build(
                meeting.getId(),
                meeting.getTitle(),
                meeting.getDescription(),
                meeting.getLocation(),
                meeting.getDateTime()
        );
    }
}
