package com.passtrack.fullstack_backend.controller;

import com.passtrack.fullstack_backend.exception.BusNotFoundException;
import com.passtrack.fullstack_backend.model.Bus;
import com.passtrack.fullstack_backend.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusController {

    @Autowired
    private BusRepository busRepository;

    @PostMapping("/bus")
    Bus newBus(@RequestBody Bus newBus) {
        return busRepository.save(newBus);
    }

    @GetMapping("/buses")
    List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @GetMapping("/bus/{busId}")
    Bus getBusById(@PathVariable Long busId) {
        return busRepository.findById(busId)
                .orElseThrow(() -> new BusNotFoundException(busId));
    }

    @PutMapping("/bus/{busId}")
    Bus updateBus(@RequestBody Bus newBus, @PathVariable Long busId) {
        return busRepository.findById(busId)
                .map(bus -> {
                    bus.setPlateNumber(newBus.getPlateNumber());
                    bus.setBusId(newBus.getBusId());
                    bus.setPrice(newBus.getPrice());
                    return busRepository.save(bus);
                }).orElseThrow(() -> new BusNotFoundException(busId));
    }

    @DeleteMapping("/buses/{busId}")
    String deleteBus (@PathVariable Long busId){
        if(!busRepository.existsById(busId)){
            throw new BusNotFoundException(busId);
        }
        busRepository.deleteById(busId);
        return "Bus with id "+busId+" has been deleted successfully";
    }
}
