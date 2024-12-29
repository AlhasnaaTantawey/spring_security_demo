package com.global.service;

import com.global.base.BaseService;
import com.global.dto.RoleDto;
import com.global.entity.Roles;
import com.global.repository.RoleRepository;
import com.global.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
 public class RoleService extends BaseService<Roles,Long> {

 private final RoleRepository roleRepository;


 public Roles findByName(String name) {
  return roleRepository.findByName(name);

 }
}
