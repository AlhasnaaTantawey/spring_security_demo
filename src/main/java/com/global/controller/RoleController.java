package com.global.controller;

import com.global.dto.AppuserDto;
import com.global.dto.RoleDto;
import com.global.entity.AppUser;
import com.global.entity.Roles;
import com.global.mapper.RoleMapper;
import com.global.service.RoleService;
import com.global.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {


    public final RoleService roleService;

    public final RoleMapper roleMapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById( Long id) {
           Roles entity= roleService.findById(id);
           RoleDto dto= roleMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
  //  @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> findAll() {
        List<Roles> entityList= roleService.findAll();
        List<RoleDto> dtoList  = roleMapper.mapList(entityList);
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody RoleDto roleDto) {
        Roles entity = roleMapper.unmap(roleDto);
        Roles appUser = roleService.insert(entity);
        RoleDto dto = roleMapper.map(appUser);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<?> Update(@RequestBody RoleDto roleDto) {
        Roles entity = roleMapper.unmap(roleDto);
        Roles appUser = roleService.update(entity);
        RoleDto dto = roleMapper.map(appUser);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        Roles entity= roleService.findByName(name);
        RoleDto  dto = roleMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

}
