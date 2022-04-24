package samuel.henhaomeet.meetingservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.models.Participant;
import samuel.henhaomeet.meetingservice.repositories.FindMeetingAdapter;
import samuel.henhaomeet.meetingservice.repositories.ModifyMeetingAdapter;

@Service
@AllArgsConstructor
public class ModifyParticipantService {
    final FindMeetingAdapter findMeetingAdapter;
    final ModifyMeetingAdapter modifyMeetingAdapter;

    public Mono<Meeting> run(
            String id,
            Participant participant
    ) {
        return findMeetingAdapter.findById(id)
                .map(meeting -> meeting.modifyParticipant(participant))
                .flatMap(modifyMeetingAdapter::modifyMeeting);
    }

}
