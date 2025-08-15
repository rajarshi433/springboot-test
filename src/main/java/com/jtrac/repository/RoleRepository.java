package com.jtrac.repository;

import com.jtrac.constants.QueryConstants;
import com.jtrac.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    @Query(nativeQuery = true, value = QueryConstants.GET_ROLE_BY_ROLE_NAME)
    Optional<RoleEntity> findRoleByName(String roleName);
}
