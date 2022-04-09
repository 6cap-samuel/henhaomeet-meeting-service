package samuel.henhaomeet.meetingservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.repositories.ModifyMeetingAdapter;

@Service
@AllArgsConstructor
public class UpdateMeetingService {

    private final ModifyMeetingAdapter modifyMeetingAdapter;

    public Mono<Meeting> run(Meeting meeting) {
        return this.modifyMeetingAdapter.modifyMeeting(
                meeting.setUpdatedDate()
        );
    }
}
