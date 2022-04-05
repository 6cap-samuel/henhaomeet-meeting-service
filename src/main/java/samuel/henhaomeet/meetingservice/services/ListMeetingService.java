package samuel.henhaomeet.meetingservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.repositories.FindMeetingAdapter;

@Service
@AllArgsConstructor
public class ListMeetingService {
    final FindMeetingAdapter findMeetingAdapter;

    public Flux<Meeting> run() {
        return findMeetingAdapter.findAll();
    }
}
