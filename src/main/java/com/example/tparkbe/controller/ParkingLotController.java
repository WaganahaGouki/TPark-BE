package com.example.tparkbe.controller;

import com.example.tparkbe.model.ParkingLot;
import com.example.tparkbe.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parkingLot")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    @GetMapping("/all")
    public ResponseEntity<List<ParkingLot>> getAllParkingLots() {
        List<ParkingLot> parkingLots = parkingLotService.findAllParkingLots();
        return new ResponseEntity<>(parkingLots, HttpStatus.OK);
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<ParkingLot> getParkingLotByName(@PathVariable("name") String name) {
        ParkingLot parkingLot = parkingLotService.findParkingLotByName(name);
        return new ResponseEntity<>(parkingLot, HttpStatus.OK);
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<ParkingLot> getParkingLotById(@PathVariable("id") Long id) {
        ParkingLot parkingLot = parkingLotService.findParkingLotById(id);
        return new ResponseEntity<>(parkingLot, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ParkingLot> addParkingLot(@RequestBody ParkingLot parkingLot) {
        ParkingLot newParkingLot = parkingLotService.addParkingLot(parkingLot);
        return new ResponseEntity<>(newParkingLot, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ParkingLot> updateParkingLot(@RequestBody ParkingLot parkingLot) {
        ParkingLot updateParkingLot = parkingLotService.updateParkingLot(parkingLot);
        return new ResponseEntity<>(updateParkingLot, HttpStatus.OK);
    }
}
