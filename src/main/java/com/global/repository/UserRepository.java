package com.global.repository;

import com.global.base.BaseRepository;
import com.global.entity.AppUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<AppUser,Long> {

    List<AppUser> findByFullName(String name);

}
