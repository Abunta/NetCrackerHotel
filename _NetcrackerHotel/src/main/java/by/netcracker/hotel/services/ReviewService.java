package by.netcracker.hotel.services;

import by.netcracker.hotel.entities.Review;

public interface ReviewService extends AbstractService<Review, Integer> {

    void addReview(Review review);

}