package samuel.henhaomeet.meetingservice.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import samuel.henhaomeet.meetingservice.dtos.MeetingDto;

public interface MeetingRepository extends ReactiveCrudRepository<MeetingDto, String> { }