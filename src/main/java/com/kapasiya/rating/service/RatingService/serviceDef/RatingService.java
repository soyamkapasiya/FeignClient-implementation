package com.kapasiya.rating.service.RatingService.serviceDef;

import com.kapasiya.rating.service.RatingService.entity.Rating;

import java.util.List;

public interface RatingService
{
    List<Rating> getAllRating();

    List<Rating> getRatingByHotelId(String hotelId);

    Rating createRating(Rating rating);

    Rating updateRating(Rating rating);

    List<Rating> getAllRatingByUserId(String userId);

    void deleteRating(String id);
}
