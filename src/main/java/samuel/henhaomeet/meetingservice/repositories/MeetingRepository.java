package samuel.henhaomeet.meetingservice.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.dtos.MeetingDto;
import samuel.henhaomeet.meetingservice.models.Meeting;

public interface MeetingRepository extends ReactiveCrudRepository<MeetingDto, String> {
//    Flux<Meeting> findById(Mono<String> id);

}
