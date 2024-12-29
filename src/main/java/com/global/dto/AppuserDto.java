package com.global.dto;

import com.global.entity.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppuserDto {

    private String userName;

    private String password;

    private String fullName;

    private List<Roles> rolesSet =new ArrayList<>();

}
