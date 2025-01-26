package com.global.dto;

import com.global.entity.Roles;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class AuthResponseDto {
    private String accessToken;
    private String username;
    private List<String> roles;

}
