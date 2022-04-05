package samuel.henhaomeet.meetingservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.repositories.CreateMeetingAdapter;

@Service
@AllArgsConstructor
public class CreateMeetingService {

    private final CreateMeetingAdapter createMeetingAdapter;

    public Mono<Meeting> run(Meeting meeting) {
        return this.createMeetingAdapter.createMeeting(
                meeting.setCreatedDate()
        );
    }
}
