package samuel.henhaomeet.meetingservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.models.Participant;
import samuel.henhaomeet.meetingservice.repositories.ModifyMeetingAdapter;
import samuel.henhaomeet.meetingservice.repositories.FindMeetingAdapter;

@Service
@AllArgsConstructor
public class AddParticipantService {

    private final FindMeetingAdapter findMeetingAdapter;
    private final ModifyMeetingAdapter modifyMeetingAdapter;

    public Mono<Meeting> run(
            String meetingId,
            Participant participant
    ){
        return this.findMeetingAdapter.findById(meetingId)
                .flatMap(
                        meeting -> modifyMeetingAdapter.modifyMeeting(
                                meeting.addParticipant(participant)
                        )
                );
    }
}
