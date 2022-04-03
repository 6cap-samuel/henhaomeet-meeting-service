package samuel.henhaomeet.meetingservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@AllArgsConstructor(staticName = "of")
@Document("meetings")
public class MeetingDto {
    @Id
    private String id;
    private String title;
    private String description;
    private String location;
    private Instant dateTime;

    public static class Factory {
        public static MeetingDto build(
                final String id,
                final String title,
                final String description,
                final String location,
                final Instant dateTime
        ){
            return MeetingDto.of(
                    id,
                    title,
                    description,
                    location,
                    dateTime
            );
        }
    }
}
