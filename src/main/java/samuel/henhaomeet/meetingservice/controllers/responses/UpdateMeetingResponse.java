package samuel.henhaomeet.meetingservice.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import samuel.henhaomeet.meetingservice.models.Meeting;

@Data
@AllArgsConstructor(staticName = "of")
public class UpdateMeetingResponse {
    private Meeting meeting;

    public static class Factory {
        public static UpdateMeetingResponse build(
                final Meeting meeting
        ){
            return UpdateMeetingResponse.of(
                    meeting
            );
        }
    }
}
