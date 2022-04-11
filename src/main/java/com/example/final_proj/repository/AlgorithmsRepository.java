package com.example.final_proj.repository;

import com.example.final_proj.models.AlgsRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlgorithmsRepository extends JpaRepository<AlgsRate, Long> {
    Optional<AlgsRate> findByName(String name);
    @Modifying
    @Query("update AlgsRate ar set ar.likes = ?2 where ar.name = ?1")
    void updateAlgsRateInfoByName(String name, Integer likes);
}
