package com.global.repository;

import com.global.base.BaseRepository;
import com.global.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<AppUser,Long> {

    // List<AppUser> findByFullName(String name);
    @Query("SELECT u FROM AppUser u JOIN FETCH u.rolesSet WHERE u.userName = :userName")
    Optional<AppUser> findByUserNameWithRoles(String userName);

    Optional<AppUser> findByUserName(String userName);
}
