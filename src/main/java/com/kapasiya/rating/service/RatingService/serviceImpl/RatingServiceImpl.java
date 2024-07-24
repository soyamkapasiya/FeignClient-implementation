package com.kapasiya.rating.service.RatingService.serviceImpl;

import com.kapasiya.rating.service.RatingService.entity.Rating;
import com.kapasiya.rating.service.RatingService.repo.RatingRepo;
import com.kapasiya.rating.service.RatingService.serviceDef.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepo ratingRepo;

    @Autowired
    public RatingServiceImpl(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return this.ratingRepo.findByHotelId(hotelId);
    }

    @Override
    public Rating createRating(Rating rating) {
        String id = UUID.randomUUID().toString().substring(0,8);
        rating.setRatingId(id);
        return ratingRepo.save(rating);
    }

    @Override
    public Rating updateRating(Rating rating) {
        return null;
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return this.ratingRepo.findByUserId(userId);
    }

    @Override
    public void deleteRating(String id) {
        ratingRepo.deleteById(id);
    }
}
