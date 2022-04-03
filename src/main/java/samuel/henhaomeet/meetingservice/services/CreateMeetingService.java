package samuel.henhaomeet.meetingservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.repositories.CreateMeetingAdapter;
import samuel.henhaomeet.meetingservice.repositories.MeetingRepository;

@Service
@AllArgsConstructor
public class CreateMeetingService {

    final CreateMeetingAdapter createMeetingAdapter;

    public Mono<Meeting> run(Meeting meeting) {
        return this.createMeetingAdapter.createMeeting(meeting);
    }
}
