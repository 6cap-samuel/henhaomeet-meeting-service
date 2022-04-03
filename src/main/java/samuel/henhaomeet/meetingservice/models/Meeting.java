package samuel.henhaomeet.meetingservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor(staticName = "of")
public class Meeting {
    private String id;
    private String title;
    private String description;
    private String location;
    private Instant dateTime;

    public static class Factory {
        public static Meeting build(
                final String id,
                final String title,
                final String description,
                final String location,
                final Instant dateTime
        ){
            return Meeting.of(
                    id,
                    title,
                    description,
                    location,
                    dateTime
            );
        }
    }
}
