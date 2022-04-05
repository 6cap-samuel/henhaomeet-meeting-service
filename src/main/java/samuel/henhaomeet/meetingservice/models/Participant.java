package samuel.henhaomeet.meetingservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Participant {
    private String imageUrl;
    private String name;
    private AttendanceStatus status;

    public static class Factory {
        public static Participant build(
                final String imageUrl,
                final String name,
                final AttendanceStatus status
        ){
            return Participant.builder()
                    .imageUrl(imageUrl)
                    .name(name)
                    .status(status)
                    .build();
        }
    }
}
