package com.global.service;

import com.global.base.BaseService;
import com.global.entity.AppUser;
import com.global.entity.Roles;
import com.global.repository.UserRepository;
import com.global.security.AppUserDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService<AppUser, Long> implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser insert(AppUser entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.insert(entity);
    }

    @Override
//    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AppUser> appUser = userRepository.findByUserName(username);
        if (!appUser.isPresent()) {
            throw new UsernameNotFoundException("this user not found with selected username:-  " + username);
        }
       // return new User(appUser.get().getUserName(), appUser.get().getPassword(), getAuthority(appUser.get()));
        return new AppUserDetail(appUser.get());
    }

//    private static List<GrantedAuthority> getAuthority(AppUser appUser) {
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if (!appUser.getRolesSet().isEmpty()) {
//            appUser.getRolesSet().forEach(roles ->
//                    authorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getName()))
//            );
//        }
//        return authorities;
//    }


}
