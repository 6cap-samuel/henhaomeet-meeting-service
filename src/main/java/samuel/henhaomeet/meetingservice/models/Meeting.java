package samuel.henhaomeet.meetingservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Instant createdDateTime;

    public Meeting addParticipant(
            final Participant participant
    ) {
        this.participantSet.add(
                participant
        );
        return this;
    }

    public Meeting setCreatedDate() {
        this.createdDateTime = Instant.now();
        return this;
    }

    public Set<Participant> getParticipantSet() {
        return participantSet == null ? new HashSet<>() : participantSet;
    }

    @JsonIgnore
    public Instant getCreatedDate() {
        return createdDateTime == null ? Instant.MIN : createdDateTime;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Factory {
        public static Meeting build(
                final String id,
                final String title,
                final String description,
                final String location,
                final Instant dateTime,
                final Set<Participant> participantSet,
                final Instant createdDateTime
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
                    )
                    .createdDateTime(createdDateTime)
                    .build();
        }
    }
}
