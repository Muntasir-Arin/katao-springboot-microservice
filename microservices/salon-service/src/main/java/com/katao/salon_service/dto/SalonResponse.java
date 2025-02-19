package com.katao.salon_service.dto;

import lombok.Builder;
import java.util.UUID;

@Builder
public record SalonResponse(
        UUID id,
        String name,
        String location,
        Boolean isFree,
        Integer queueSize
) {}
