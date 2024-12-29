package com.global.repository;

import com.global.base.BaseRepository;
import com.global.entity.Roles;

public interface RoleRepository  extends BaseRepository<Roles,Long> {

     Roles findByName(String name);
}
