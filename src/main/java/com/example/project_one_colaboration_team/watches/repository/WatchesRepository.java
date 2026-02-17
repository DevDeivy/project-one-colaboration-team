package com.example.project_one_colaboration_team.watches.repository;

import com.example.project_one_colaboration_team.watches.model.Watches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchesRepository extends JpaRepository<Watches, Long> {
    boolean existsByModel (String model);
    boolean existsById (Long id);
}
