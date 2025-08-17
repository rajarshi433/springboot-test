package com.jtrac.repository;

import com.jtrac.constants.*;
import com.jtrac.entity.PDNEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

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
                Boolean delivered, Boolean sentBack, String subModule, Integer userId);

    @Query(nativeQuery = true, value = QueryConstants.GET_ALL_PDNS)
    List<PDNEntity> findAllPDNs();

    @Query(nativeQuery = true, value = QueryConstants.GET_PDNS_BY_GIT)
    List<PDNEntity> findPDNsByGit(String git);

    @Query(nativeQuery = true, value = QueryConstants.GET_PDNS_BY_DEVELOPER)
    List<PDNEntity> findPDNsByDeveloper(Long userId);

    @Query(nativeQuery = true, value = QueryConstants.GET_PDNS_BY_REVIEWER)
    List<PDNEntity> findPDNsByReviewer(Long reviewerId);

    @Query(nativeQuery = true, value = QueryConstants.GET_PDNS_NOT_REVIEWED)
    List<PDNEntity> findPDNsNotReviewed(Long userId);

    @Query(nativeQuery = true, value = QueryConstants.GET_PDNS_NOT_DEPLOYED)
    List<PDNEntity> findPDNsNotDeployed();

    @Query(nativeQuery = true, value = QueryConstants.GET_PDNS_BY_FILTER_OBJ)
    List<PDNEntity> findPDNsByFilterObj();
}
