package com.katao.salon_service.repository;

import com.katao.salon_service.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface SalonRepository extends JpaRepository<Salon, UUID> {
    List<Salon> findByLocation(String location);
}
