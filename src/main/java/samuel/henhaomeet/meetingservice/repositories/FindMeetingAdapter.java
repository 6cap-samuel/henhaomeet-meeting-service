package samuel.henhaomeet.meetingservice.repositories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.repositories.mappers.DtoToMeetingMapper;

import java.util.Comparator;

@Service
@AllArgsConstructor
public class FindMeetingAdapter {

    private final MeetingRepository meetingRepository;
    private final DtoToMeetingMapper dtoToMeetingMapper;

    public Mono<Meeting> findById(String id) {
        return this.meetingRepository
                .findById(id)
                .map(dtoToMeetingMapper::map);
    }

    public Flux<Meeting> findAll() {
         return this.meetingRepository
                 .findAll()
                 .map(dtoToMeetingMapper::map)
                 .sort(Comparator.comparing(Meeting::getCreatedDate).reversed());
    }
}
