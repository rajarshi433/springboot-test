package com.jtrac.repository;

import com.jtrac.constants.QueryConstants;
import com.jtrac.entity.RoleEntity;
import com.jtrac.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(nativeQuery = true, value = QueryConstants.GET_ALL_USERS)
    List<UserEntity> findAllUsers();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = QueryConstants.INSERT_USER)
    int saveUser(Long empId, String firstName, String lastName, Long password, String role);
}
