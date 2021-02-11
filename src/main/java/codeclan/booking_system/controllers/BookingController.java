package codeclan.booking_system.controllers;

import codeclan.booking_system.models.Booking;
import codeclan.booking_system.models.Customer;
import codeclan.booking_system.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

//    Handling routes and filters:
//    GET /bookings
//    GET /bookings?course=IntroJava

    @GetMapping("/bookings")
    public ResponseEntity <List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Optional<Booking>> getBookingById(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/bookings/{date}")
    public ResponseEntity <List<Booking>> getBookingsByDate(@PathVariable String date){
        return new ResponseEntity<>(bookingRepository.getBookingsByDate(date), HttpStatus.OK);
    }



//    @PostMapping("/bookings")
//    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
//        Booking booking1 = new Booking("Intro to Python", Customer customer, "21/01/21");
//        return new ResponseEntity<>(bookingRepository.save(booking1), HttpStatus.CREATED);
//    }

}
