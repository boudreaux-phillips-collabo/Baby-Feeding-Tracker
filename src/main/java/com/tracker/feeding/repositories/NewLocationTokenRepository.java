package com.tracker.feeding.repositories;

import com.tracker.feeding.models.NewLocationToken;
import com.tracker.feeding.models.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewLocationTokenRepository extends JpaRepository<NewLocationToken, Long> {

    NewLocationToken findByToken(String token);

    NewLocationToken findByUserLocation(UserLocation userLocation);

}
