package com.tihic.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    
    @Query("SELECT u FROM Restaurant u WHERE u.userName = ?1")
    User findByName(String userName);
    
}
