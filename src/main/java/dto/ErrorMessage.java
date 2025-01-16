package dto;

import lombok.*;

@Data
@Builder
public class ErrorMessage {
    private String title;
    private String status;
    private String details;
}
