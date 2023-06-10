package com.example.tparkbe.controller;

import com.example.tparkbe.model.ParkingLotRequest;
import com.example.tparkbe.service.ParkingLotRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parkingLotRequest")
public class ParkingLotRequestController {
    private final ParkingLotRequestService parkingLotRequestService;

    @GetMapping("/all")
    public ResponseEntity<List<ParkingLotRequest>> getAllParkingLotRequests() {
        List<ParkingLotRequest> parkingLotRequests = parkingLotRequestService.findAllParkingLotRequests();
        return new ResponseEntity<>(parkingLotRequests, HttpStatus.OK);
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<ParkingLotRequest> getParkingLotRequestByName(@PathVariable("name") String name) {
        ParkingLotRequest parkingLotRequest = parkingLotRequestService.findParkingLotRequestByName(name);
        return new ResponseEntity<>(parkingLotRequest, HttpStatus.OK);
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<ParkingLotRequest> getParkingLotRequestById(@PathVariable("id") Long id) {
        ParkingLotRequest parkingLotRequest = parkingLotRequestService.findParkingLotRequestById(id);
        return new ResponseEntity<>(parkingLotRequest, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ParkingLotRequest> addParkingLotRequest(@RequestBody ParkingLotRequest parkingLotRequest) {
        ParkingLotRequest newParkingLotRequest = parkingLotRequestService.addParkingLotRequest(parkingLotRequest);
        return new ResponseEntity<>(newParkingLotRequest, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteParkingLotRequest(@PathVariable("id") Long id) {
        parkingLotRequestService.deleteParkingLotRequest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
