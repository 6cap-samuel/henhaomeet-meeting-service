package samuel.henhaomeet.meetingservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.codec.multipart.Part;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Data
@Builder
public class Meeting {
    private String id;
    private String title;
    private String description;
    private String location;
    private Instant dateTime;
    private Set<Participant> participantSet;

    public Meeting addParticipant(
            final Participant participant
    ) {
        this.participantSet.add(
                participant
        );
        return this;
    }

    public static class Factory {
        public static Meeting build(
                final String id,
                final String title,
                final String description,
                final String location,
                final Instant dateTime,
                final Set<Participant> participantSet
        ){
            return Meeting.builder()
                    .id(id)
                    .title(title)
                    .description(description)
                    .location(location)
                    .dateTime(dateTime)
                    .participantSet(participantSet)
                    .build();
        }
    }
}
