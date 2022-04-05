package samuel.henhaomeet.meetingservice.dtos;

import lombok.Builder;
import lombok.Data;
import samuel.henhaomeet.meetingservice.models.AttendanceStatus;

@Data
@Builder
public class ParticipantDto {
    private String imageUrl;
    private String name;
    private AttendanceStatus status;

    public static class Factory {
        public static ParticipantDto build(
                final String imageUrl,
                final String name,
                final AttendanceStatus status
        ){
            return ParticipantDto.builder()
                    .imageUrl(imageUrl)
                    .name(name)
                    .status(status)
                    .build();
        }
    }
}
