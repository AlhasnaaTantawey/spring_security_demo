package com.global.service;

import com.global.config.JwtTokenProvider;
import com.global.dto.AuthResponseDto;
import com.global.dto.LoginDto;
import com.global.entity.AppUser;
import com.global.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public AuthResponseDto login(LoginDto loginDto) {

        // 01 - AuthenticationManager is used to authenticate the user
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()
        ));

        /* 02 - SecurityContextHolder is used to allows the rest of the application to know
        that the user is authenticated and can use user data from Authentication object */
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 03 - Generate the token based on username and secret key
        String token = jwtTokenProvider.generateToken(authentication);
       AppUser user= userRepository.findByUserName(authentication.getName()).get();
          List<String> rolesList=   user.getRolesSet()
                      .stream()
                      .map(roles -> roles.getName())
                      .collect(Collectors.toList());


        // Prepare the response
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setAccessToken(token);
        authResponseDto.setUsername(user.getUserName());
        authResponseDto.setRoles(rolesList);
        // 04 - Return the token to controller
        return authResponseDto;
    }
}
