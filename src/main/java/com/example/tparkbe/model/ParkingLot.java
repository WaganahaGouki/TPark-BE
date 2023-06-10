package com.example.tparkbe.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private double lat;
    private double lng;
    private int carSlots;
    private int busSlots;
    private int handicapSlots;
    private int pricePerHour;
    private String zone;
    private String name;
}
