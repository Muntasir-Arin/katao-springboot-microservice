package com.katao.salon_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalonRequest {
    @NotBlank(message = "Salon name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;
}
