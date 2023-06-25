package com.example.tparkbe.repo;

import com.example.tparkbe.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ParkingLotRepo extends JpaRepository<ParkingLot, Long> {
    Optional<ParkingLot> findParkingLotByName(String name);

    Optional<ParkingLot> findParkingLotById(Long id);

    void deleteParkingLotByName(String name);
}
