package com.katao.salon_service.controller;

import com.katao.salon_service.dto.SalonRequest;
import com.katao.salon_service.dto.SalonResponse;
import com.katao.salon_service.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/salons")
@RequiredArgsConstructor
public class SalonController {

    @Autowired
    private SalonService salonService;

    @GetMapping
    public ResponseEntity<List<SalonResponse>> getAllSalons() {
        return ResponseEntity.ok(salonService.getAllSalons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalonResponse> getSalonById(@PathVariable UUID id) {
        return ResponseEntity.ok(salonService.getSalonById(id));
    }

    @PostMapping("/{ownerId}")
    public ResponseEntity<SalonResponse> createSalon(@RequestBody SalonRequest request, @PathVariable UUID ownerId) {
        return ResponseEntity.ok(salonService.createSalon(request, ownerId));
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<String> updateSalonAvailability(@PathVariable UUID id, @RequestParam boolean isFree) {
        salonService.updateSalonAvailability(id, isFree);
        return ResponseEntity.ok("Salon availability updated");
    }
}
