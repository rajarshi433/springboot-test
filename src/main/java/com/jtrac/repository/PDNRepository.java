package com.jtrac.repository;

import com.jtrac.constants.*;
import com.jtrac.entity.PDNEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PDNRepository extends JpaRepository<PDNEntity, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = QueryConstants.CREATE_PDN)
    int savePDN(String components, LocalDateTime createdAt,
                String deploymentStatus, String description, String developer,
                String git, LocalDateTime lastUpdated, String loggedBy, String module,
                String pdnNumber, String problemId, String problemSource, String product,
                String reviewStatus, String reviewerName, Long reviewerId,
                Boolean sentBack, String subModule, Integer userId);
}
