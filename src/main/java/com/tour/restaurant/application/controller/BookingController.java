package com.tour.restaurant.application.controller;
import com.tour.restaurant.Domain.DTO.*;
import com.tour.restaurant.Domain.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAll(){
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<BookingDTO> getByID(@PathVariable("id") long bookingID){
        return bookingService.getBookingById(bookingID).map(bookingDTO -> new ResponseEntity<>(bookingDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<BookingDTO> save (@RequestBody BookingDTO booking){
        return new ResponseEntity<>(bookingService.save(booking),  HttpStatus.CREATED) ;
    }


    @DeleteMapping("{id}")
    public ResponseEntity delete (@PathVariable("id") Long bookingID){
        if (bookingService.delete(bookingID)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
