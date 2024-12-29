package com.global.entity;

import com.global.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sec_users",schema = "hr")
public class AppUser extends BaseEntity<Long> {

    @Column(name = "user_name")
    private String userName;

    private String password;
    @Column(name = "full_name")
    private String fullName;

    @ManyToMany
    @JoinTable(name = "sec_user_roles" ,
    joinColumns = @JoinColumn(name = "user_id") ,
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    @OrderColumn(name = "role_position")
    @Column(name = "roles")
    private List<Roles> rolesSet =new ArrayList<>();
}
