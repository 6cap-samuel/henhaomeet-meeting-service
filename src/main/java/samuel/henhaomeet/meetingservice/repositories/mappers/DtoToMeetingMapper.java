package samuel.henhaomeet.meetingservice.repositories.mappers;

import org.springframework.stereotype.Component;
import samuel.henhaomeet.meetingservice.dtos.MeetingDto;
import samuel.henhaomeet.meetingservice.models.Meeting;

@Component
public class DtoToMeetingMapper {
    public Meeting map(MeetingDto meetingDto) {
        return Meeting.Factory.build(
                meetingDto.getId(),
                meetingDto.getTitle(),
                meetingDto.getDescription(),
                meetingDto.getLocation(),
                meetingDto.getDateTime()
        );
    }
}
