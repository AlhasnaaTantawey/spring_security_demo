package com.global.config;

import com.global.entity.AppUser;
import com.global.entity.Roles;
import com.global.service.RoleService;
import com.global.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class StartUp implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {

        if(roleService.findAll().isEmpty()){
            roleService.insert(new Roles("admin"));
            roleService.insert(new Roles("employee"));
            roleService.insert(new Roles("user"));
        }

          List<Roles> adminRoles =new ArrayList<>();
            adminRoles.add(roleService.findByName("admin"));


        List<Roles> userRoles =new ArrayList<>();
        adminRoles.add(roleService.findByName("user"));

        List<Roles> empRoles =new ArrayList<>();
        adminRoles.add(roleService.findByName("employee"));

         if (userService.findAll().isEmpty()){
             userService.insert(
                     new AppUser("alhasnaa","123","alhasnaa elsayed",adminRoles));

             userService.insert(
                     new AppUser("alzhraa","123","alzhraa elsayed",userRoles));

             userService.insert(
                     new AppUser("alshimaa","123","alshimaa elsayed",empRoles));
         }

//
//        if (userService.findAll().isEmpty() && roleService.findAll().isEmpty()) {
//
//            // Save roles first
//            Roles roleAdmin = roleService.insert(new Roles("admin"));
//            Roles roleEmployee = roleService.insert(new Roles("employee"));
//            Roles roleHR = roleService.insert(new Roles("hr"));
//
//            // Create users with roles
//            AppUser user1 = new AppUser();
//            user1.setFullName("Alhasnaa elsayed");
//            user1.setUserName("hasnaa");
//            user1.setPassword("123");
//            user1.setRolesSet(List.of(roleAdmin)); // Use roles with IDs
//
//            AppUser user2 = new AppUser();
//            user2.setFullName("Alzhraa elsayed");
//            user2.setUserName("zhraa");
//            user2.setPassword("123");
//            user2.setRolesSet(List.of(roleEmployee));
//
//            AppUser user3 = new AppUser();
//            user3.setFullName("Alshimaa elsayed");
//            user3.setUserName("shimaa");
//            user3.setPassword("123");
//            user3.setRolesSet(List.of(roleHR));
//            System.out.println("User Roles: " + user1.getRolesSet());
//
//            // Save users
//            userService.insert(List.of(user1, user2, user3));
//        }
    }

}
