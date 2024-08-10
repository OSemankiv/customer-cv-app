package com.customerapp.customerappdemo.repository;

import com.customerapp.customerappdemo.entity.CandidateEntity;
import com.customerapp.customerappdemo.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

    @Query("""
            SELECT c FROM Candidate c
            JOIN FETCH c.position pos
            WHERE pos.id  in (:positionIds)
            """)
    List<CandidateEntity> findAllByPositionIds(List<UUID> positionIds);
}
