package com.kapasiya.rating.service.RatingService.controller;

import com.kapasiya.rating.service.RatingService.entity.Rating;
import com.kapasiya.rating.service.RatingService.serviceDef.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController
{
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings()
    {
        List<Rating> list = ratingService.getAllRating();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(Rating rating)
    {
        Rating rating1 = this.ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @DeleteMapping("/deleteRatingByID/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id)
    {
        this.ratingService.deleteRating(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Rating");
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId)
    {
        List<Rating> list = ratingService.getAllRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId)
    {
        List<Rating> list = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
