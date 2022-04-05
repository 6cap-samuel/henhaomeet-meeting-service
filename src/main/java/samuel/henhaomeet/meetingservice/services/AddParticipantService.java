package samuel.henhaomeet.meetingservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.models.Participant;
import samuel.henhaomeet.meetingservice.repositories.CreateMeetingAdapter;
import samuel.henhaomeet.meetingservice.repositories.FindMeetingAdapter;

@Service
@AllArgsConstructor
public class AddParticipantService {

    private final FindMeetingAdapter findMeetingAdapter;
    private final CreateMeetingAdapter createMeetingAdapter;

    public Mono<Meeting> run(
            String meetingId,
            Participant participant
    ){
        return this.findMeetingAdapter.findById(meetingId)
                .flatMap(
                        meeting -> createMeetingAdapter.createMeeting(
                                meeting.addParticipant(participant)
                        )
                );
    }
}
