package com.example.tparkbe.service;

import com.example.tparkbe.exception.NotFoundException;
import com.example.tparkbe.model.ParkingLot;
import com.example.tparkbe.repo.ParkingLotRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingLotService {
    private final ParkingLotRepo parkingLotRepo;

    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        boolean parkingLotExists = parkingLotRepo
                .findParkingLotByName(parkingLot.getName())
                .isPresent();
        if(parkingLotExists) {
            throw new IllegalStateException("Name already taken!");
        }
        return parkingLotRepo.save(parkingLot);
    }

    public ParkingLot updateParkingLot(ParkingLot parkingLot) {
        boolean parkingLotExists = parkingLotRepo
                .findParkingLotById(parkingLot.getId())
                .isPresent();
        if(!parkingLotExists) {
            throw new IllegalStateException("Parking lot doesn't exist!");
        }
        return parkingLotRepo.save(parkingLot);
    }

    public void deleteParkingLot(String name) {
        boolean parkingLotExists = parkingLotRepo
                .findParkingLotByName(name)
                .isPresent();
        if(!parkingLotExists) {
            throw new IllegalStateException("Parking lot doesn't exist!");
        }
        parkingLotRepo.deleteParkingLotByName(name);
    }

    public List<ParkingLot> findAllParkingLots() {
        return parkingLotRepo.findAll();
    }

    public ParkingLot findParkingLotByName(String name) {
        return parkingLotRepo.findParkingLotByName(name).orElseThrow(() -> new NotFoundException("Parking lot by name " + name + " was not found!"));
    }

    public ParkingLot findParkingLotById(Long id) {
        return parkingLotRepo.findParkingLotById(id).orElseThrow(() -> new NotFoundException("Parking lot by id " + id + " was not found!"));
    }
}
