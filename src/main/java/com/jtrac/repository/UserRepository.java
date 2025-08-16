package com.jtrac.repository;

import com.jtrac.constants.QueryConstants;
import com.jtrac.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(nativeQuery = true, value = QueryConstants.GET_ALL_USERS)
    List<UserEntity> findAllUsers();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = QueryConstants.CREATE_USER)
    int saveUser(Long empId, String firstName, String lastName, Long password, String role);
}
