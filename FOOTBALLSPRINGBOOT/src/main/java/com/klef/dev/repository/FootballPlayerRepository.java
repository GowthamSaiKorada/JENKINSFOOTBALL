package com.klef.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.klef.dev.entity.FootballPlayer;

@Repository
public interface FootballPlayerRepository extends JpaRepository<FootballPlayer, Integer> {
    // Add custom finders if needed (e.g., findByTeam, findByNationality)
}
