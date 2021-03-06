package samuel.henhaomeet.meetingservice.repositories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.repositories.mappers.DtoToMeetingMapper;
import samuel.henhaomeet.meetingservice.repositories.mappers.MeetingToDtoMapper;

@Service
@AllArgsConstructor
public class ModifyMeetingAdapter {

    private final MeetingRepository meetingRepository;
    private final DtoToMeetingMapper dtoToMeetingMapper;
    private final MeetingToDtoMapper meetingToDtoMapper;

    public Mono<Meeting> modifyMeeting(Meeting meeting) {
        return this.meetingRepository.save(
                meetingToDtoMapper.map(
                        meeting
                )
        ).map(dtoToMeetingMapper::map);
    }
}
