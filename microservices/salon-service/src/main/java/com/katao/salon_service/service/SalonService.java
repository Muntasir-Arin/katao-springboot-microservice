package com.katao.salon_service.service;

import com.katao.salon_service.dto.SalonResponse;
import com.katao.salon_service.exception.SalonNotFoundException;
import com.katao.salon_service.model.Salon;
import com.katao.salon_service.repository.SalonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.katao.salon_service.dto.SalonRequest;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;

    public List<SalonResponse> getAllSalons() {
        return salonRepository.findAll()
                .stream()
                .map(salon -> SalonResponse.builder()
                        .id(salon.getId())
                        .name(salon.getName())
                        .location(salon.getLocation())
                        .isFree(salon.getIsFree())
                        .queueSize(salon.getQueueSize())
                        .build())
                .collect(Collectors.toList());
    }

    public SalonResponse getSalonById(UUID id) {
        Salon salon = salonRepository.findById(id)
                .orElseThrow(() -> new SalonNotFoundException("Salon not found with ID: " + id));

        return SalonResponse.builder()
                .id(salon.getId())
                .name(salon.getName())
                .location(salon.getLocation())
                .isFree(salon.getIsFree())
                .queueSize(salon.getQueueSize())
                .build();
    }

    public SalonResponse createSalon(SalonRequest request, UUID ownerId) {
        Salon salon = Salon.builder()
                .name(request.getName())
                .location(request.getLocation())
                .isFree(true)  // Default to free
                .queueSize(0)
                .ownerId(ownerId)
                .build();

        Salon savedSalon = salonRepository.save(salon);
        return SalonResponse.builder()
                .id(savedSalon.getId())
                .name(savedSalon.getName())
                .location(savedSalon.getLocation())
                .isFree(savedSalon.getIsFree())
                .queueSize(savedSalon.getQueueSize())
                .build();
    }

    public void updateSalonAvailability(UUID id, boolean isFree) {
        Salon salon = salonRepository.findById(id)
                .orElseThrow(() -> new SalonNotFoundException("Salon not found with ID: " + id));

        salon.setIsFree(isFree);
        salonRepository.save(salon);
    }
}
