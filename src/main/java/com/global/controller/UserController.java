package com.global.controller;

import com.global.dto.AppuserDto;
import com.global.entity.AppUser;
import com.global.mapper.UserMapper;
import com.global.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

   @Autowired
    public  UserService userService;

    @Autowired
    public  UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById( Long id) {
           AppUser entity= userService.findById(id);
           AppuserDto dto= userMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<AppUser> entityList	= userService.findAll();
        List<AppuserDto> dtoList    = userMapper.mapList(entityList);
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody AppuserDto appuserDto) {
        AppUser entity = userMapper.unmap(appuserDto);
        AppUser appUser = userService.insert(entity);
        AppuserDto dto = userMapper.map(appUser);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody AppuserDto appuserDto) {
        AppUser entity = userMapper.unmap(appuserDto);
        AppUser appUser = userService.update(entity);
        AppuserDto dto = userMapper.map(appUser);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
