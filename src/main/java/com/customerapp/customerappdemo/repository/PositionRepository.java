package com.customerapp.customerappdemo.repository;

import com.customerapp.customerappdemo.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, UUID> {

    Optional<PositionEntity> findByIdAndProjectId(UUID id, UUID projectId);

    void deleteByIdAndProjectId(UUID id, UUID projectId);
}
