package samuel.henhaomeet.meetingservice.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Document("meetings")
public class MeetingDto {
    @Id
    private String id;
    private String title;
    private String description;
    private String location;
    private Instant dateTime;
    private Set<ParticipantDto> participants;
    private Instant createdDateTime;

    public Set<ParticipantDto> getParticipants() {
        return participants == null ? new HashSet<>() : participants;
    }

    public static class Factory {
        public static MeetingDto build(
                final String id,
                final String title,
                final String description,
                final String location,
                final Instant dateTime,
                final Set<ParticipantDto> participantDtoSet,
                final Instant createdDateTime
        ){
            return MeetingDto.builder()
                    .id(id)
                    .title(title)
                    .description(description)
                    .location(location)
                    .dateTime(dateTime)
                    .participants(participantDtoSet)
                    .createdDateTime(createdDateTime)
                    .build();
        }
    }
}
