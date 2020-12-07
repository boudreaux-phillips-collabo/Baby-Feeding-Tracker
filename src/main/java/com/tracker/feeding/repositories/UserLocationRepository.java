package com.tracker.feeding.repositories;

import com.tracker.feeding.models.User;
import com.tracker.feeding.models.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, User user);

}
