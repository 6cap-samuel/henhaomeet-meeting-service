package samuel.henhaomeet.meetingservice.repositories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.repositories.mappers.DtoToMeetingMapper;
import samuel.henhaomeet.meetingservice.repositories.mappers.MeetingToDtoMapper;

@Service
@AllArgsConstructor
public class CreateMeetingAdapter {
    final DtoToMeetingMapper dtoToMeetingMapper;
    final MeetingToDtoMapper meetingToDtoMapper;
    final MeetingRepository meetingRepository;

    public Mono<Meeting> createMeeting(Meeting meeting) {
        return this.meetingRepository.save(
                meetingToDtoMapper.map(
                        meeting
                )
        ).map(dtoToMeetingMapper::map);
    }
}
