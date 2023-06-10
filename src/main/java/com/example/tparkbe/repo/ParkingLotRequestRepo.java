package com.example.tparkbe.repo;

import com.example.tparkbe.model.ParkingLotRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ParkingLotRequestRepo extends JpaRepository<ParkingLotRequest, Long> {
    Optional<ParkingLotRequest> findParkingLotRequestByName(String name);

    Optional<ParkingLotRequest> findParkingLotRequestById(Long id);

    void deleteParkingLotRequestById(Long id);
}
