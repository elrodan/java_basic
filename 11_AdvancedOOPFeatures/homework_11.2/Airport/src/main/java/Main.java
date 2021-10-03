package main.java;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        LocalDateTime currentTime = LocalDateTime.now();
        return airport.getTerminals().stream()
                .flatMap(t -> t.getFlights().stream())
                .filter(f -> f.getType() == Flight.Type.DEPARTURE)
                .filter(f -> f.getDate().toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDateTime().isBefore(currentTime.plusHours(2)) && f.getDate().toInstant()
                        .atZone(ZoneId.systemDefault()).toLocalDateTime().isAfter(currentTime))
                .collect(Collectors.toList());
    }

}