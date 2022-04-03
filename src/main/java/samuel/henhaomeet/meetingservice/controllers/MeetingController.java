package samuel.henhaomeet.meetingservice.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.controllers.mappers.MeetingToResponseMapper;
import samuel.henhaomeet.meetingservice.controllers.mappers.RequestToMeetingMapper;
import samuel.henhaomeet.meetingservice.controllers.requests.CreateMeetingRequest;
import samuel.henhaomeet.meetingservice.controllers.responses.CreateMeetingResponse;
import samuel.henhaomeet.meetingservice.services.CreateMeetingService;

@RestController
@RequestMapping("/meetings")
@Slf4j
@AllArgsConstructor
public class MeetingController {

    private final CreateMeetingService createMeetingService;
    private final MeetingToResponseMapper responseMapper;
    private final RequestToMeetingMapper requestMapper;

    @PostMapping
    public ResponseEntity<Mono<CreateMeetingResponse>> createMeeting(
            @RequestBody CreateMeetingRequest createMeetingRequest
    ) {
        return ResponseEntity.ok(
                createMeetingService.run(
                        requestMapper.map(createMeetingRequest)
                ).map(
                        responseMapper::map
                )
        );
    }
}
