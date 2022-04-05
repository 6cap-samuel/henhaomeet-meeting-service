package samuel.henhaomeet.meetingservice.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import samuel.henhaomeet.meetingservice.controllers.mappers.MeetingToResponseMapper;
import samuel.henhaomeet.meetingservice.controllers.mappers.RequestToMeetingMapper;
import samuel.henhaomeet.meetingservice.controllers.mappers.RequestToParticipantMapper;
import samuel.henhaomeet.meetingservice.controllers.requests.AddParticipantRequest;
import samuel.henhaomeet.meetingservice.controllers.requests.CreateMeetingRequest;
import samuel.henhaomeet.meetingservice.controllers.responses.CreateMeetingResponse;
import samuel.henhaomeet.meetingservice.models.Meeting;
import samuel.henhaomeet.meetingservice.services.AddParticipantService;
import samuel.henhaomeet.meetingservice.services.CreateMeetingService;
import samuel.henhaomeet.meetingservice.services.ListMeetingService;

@RestController
@RequestMapping("/meeting")
@Slf4j
@AllArgsConstructor
public class MeetingController {

    private final CreateMeetingService createMeetingService;
    private final AddParticipantService addParticipantService;
    private final ListMeetingService listMeetingService;

    private final MeetingToResponseMapper responseMapper;
    private final RequestToMeetingMapper requestToMeetingMapper;
    private final RequestToParticipantMapper requestToParticipantMapper;

    @PostMapping
    public ResponseEntity<Mono<CreateMeetingResponse>> createMeeting(
            @RequestBody CreateMeetingRequest createMeetingRequest
    ) {
        return ResponseEntity.ok(
                createMeetingService.run(
                        requestToMeetingMapper.map(createMeetingRequest)
                ).map(
                        responseMapper::map
                )
        );
    }

    @GetMapping
    public ResponseEntity<Flux<Meeting>> listAllMeeting() {
        return ResponseEntity.ok(
                listMeetingService.run()
        );
    }

    @PostMapping("/{id}/participant")
    public ResponseEntity<Mono<CreateMeetingResponse>> addParticipant(
            @PathVariable("id") String meetingId,
            @RequestBody AddParticipantRequest addParticipantRequest
    ) {
        return ResponseEntity.ok(
                addParticipantService.run(
                        meetingId,
                        requestToParticipantMapper.map(addParticipantRequest)
                ).map(
                        responseMapper::map
                )
        );
    }
}
