package samuel.henhaomeet.meetingservice.models;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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

    public Set<Participant> getParticipantSet() {
        return participantSet == null ? new HashSet<>() : participantSet;
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
                    .participantSet(
                            participantSet == null ?
                                    new HashSet<>() :
                                    participantSet
                    ).build();
        }
    }
}
