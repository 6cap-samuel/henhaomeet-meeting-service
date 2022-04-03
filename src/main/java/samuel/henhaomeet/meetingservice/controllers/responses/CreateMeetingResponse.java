package samuel.henhaomeet.meetingservice.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import samuel.henhaomeet.meetingservice.models.Meeting;

@Data
@AllArgsConstructor(staticName = "of")
public class CreateMeetingResponse {
    private Meeting meeting;

    public static class Factory {
        public static CreateMeetingResponse build(
                final Meeting meeting
        ){
            return CreateMeetingResponse.of(
                   meeting
            );
        }
    }
}
