package com.example.tparkbe.service;

import com.example.tparkbe.exception.NotFoundException;
import com.example.tparkbe.model.ParkingLotRequest;
import com.example.tparkbe.repo.ParkingLotRequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingLotRequestService {
    private final ParkingLotRequestRepo parkingLotRequestRepo;

    public ParkingLotRequest addParkingLotRequest(ParkingLotRequest parkingLotRequest) {
        return parkingLotRequestRepo.save(parkingLotRequest);
    }

    public void deleteParkingLotRequest(String name) {
        boolean parkingLotRequestExists = parkingLotRequestRepo
                .findParkingLotRequestByName(name)
                .isPresent();
        if(!parkingLotRequestExists) {
            throw new IllegalStateException("Parking lot request doesn't exist!");
        }
        parkingLotRequestRepo.deleteParkingLotRequestByName(name);
    }

    public List<ParkingLotRequest> findAllParkingLotRequests() {
        return parkingLotRequestRepo.findAll();
    }

    public ParkingLotRequest findParkingLotRequestByName(String name) {
        return parkingLotRequestRepo.findParkingLotRequestByName(name).orElseThrow(() -> new NotFoundException("Parking lot request by name " + name + " was not found!"));
    }

    public ParkingLotRequest findParkingLotRequestById(Long id) {
        return parkingLotRequestRepo.findParkingLotRequestById(id).orElseThrow(() -> new NotFoundException("Parking lot request by id " + id + " was not found!"));
    }
}
