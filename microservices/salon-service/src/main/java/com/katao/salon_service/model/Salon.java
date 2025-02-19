package com.katao.salon_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Salon name is required")
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Boolean isFree = true;

    private Integer queueSize = 0;

    @Column(nullable = false)
    private UUID ownerId;

    private LocalDateTime createdAt = LocalDateTime.now();
}
