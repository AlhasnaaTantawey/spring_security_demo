//package com.global.security;
//
//import com.global.service.UserService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Log4j2
//@RequiredArgsConstructor
//public class AuthFilter extends OncePerRequestFilter {
//
//    private final UserService userService;
//    private final JwtTokenUtils tokenUtils;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//          final String jwtTokenHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//          log.info("Path is >>" + request.getRequestURI());
//       final   SecurityContext securityContext= SecurityContextHolder.getContext();
//
//       if(jwtTokenHeader !=null && securityContext.getAuthentication()==null){
//           String jwtToken= jwtTokenHeader.substring("Bearer".length());
//
//           if (tokenUtils.validateToken(jwtToken,request)){
//             String userName= tokenUtils.getUserNameFromToken(jwtToken);
//             if(userName != null){
//                 AppUserDetail appUserDetail  = (AppUserDetail)  userService.loadUserByUsername(userName);
//                 if (tokenUtils.isTokenValid(jwtToken,appUserDetail)){
//                     UsernamePasswordAuthenticationToken authentication=
//                             new UsernamePasswordAuthenticationToken(appUserDetail,null,appUserDetail.getAuthorities());
//                     authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                     SecurityContextHolder.getContext().setAuthentication(authentication);
//                 }
//             }
//           }
//       }
//       filterChain.doFilter(request,response);
//    }
//
//
//}
