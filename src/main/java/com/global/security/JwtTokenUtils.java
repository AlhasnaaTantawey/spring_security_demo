//package com.global.security;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.SignatureException;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//
//import java.util.Calendar;
//import java.util.Date;
//
//@Log4j2
//@Component
//public class JwtTokenUtils {
//
//    private static String TOKEN_SECRET;
//    private static long ACCESS_TOKEN_VALIDITY;
//    private static long REFRESH_TOKEN_VALIDITY;
//
//    public JwtTokenUtils(@Value("$(auth.secret)") String secretKey,
//                         @Value("$(auth.access.expiration)") Long accessValidity ,@Value("$(auth.refresh.expiration)") Long refreshValidity) {
//        Assert.notNull(accessValidity," validity must not be null");
//        Assert.notNull(secretKey," validity must not be null or empty");
//
//        TOKEN_SECRET=secretKey;
//        ACCESS_TOKEN_VALIDITY=accessValidity;
//        REFRESH_TOKEN_VALIDITY=refreshValidity;
//    }
//
//    public static String generateToken( final String userName , final String tokenId , final boolean isRefresh){
//        return Jwts.builder()
//                .setId(tokenId)
//                .setSubject(userName)
//                .setIssuedAt(new Date())
//                .setIssuer("app-service")
//                .setExpiration(calcTokenExpirationDate( isRefresh))
//                .claim("created", Calendar.getInstance().getTime())
//                .signWith(SignatureAlgorithm.HS512,TOKEN_SECRET).compact();
//
//    }
//
//    private static Date calcTokenExpirationDate(boolean isRefresh) {
//        return new Date(System.currentTimeMillis()+ (isRefresh ? REFRESH_TOKEN_VALIDITY :ACCESS_TOKEN_VALIDITY * 1000));
//    }
//
//    public String getUserNameFromToken(String token){
//        Claims claims=getClaims(token);
//        return claims.getSubject();
//    }
//
//    private Claims getClaims(String token) {
//        return Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJwt(token).getBody();
//    }
//
//    public String getTokenIdFromToken(String token){
//        Claims claims=getClaims(token);
//        return claims.getId();
//    }
//
//    public boolean isTokenValid(String token ,AppUserDetail userDetail){
//        log.info("isTokenExpired >>>" + isTokenExpired(token));
//        String userName=getUserNameFromToken(token);
//        log.info("userNameFromToken >>>" + userName);
//        log.info("userDetails.getUserName >>>" + userDetail.getUsername());
//        log.info("userName= >>> userDeatils.getUserName >>>" + userName.equals(userDetail.getUsername()));
//        boolean isUserNameEqual =userName.equalsIgnoreCase(userDetail.getUsername());
//        return (isUserNameEqual && !isTokenExpired(token));
//
//    }
//
//    private boolean isTokenExpired(String token) {
//       Date expiration=  getClaims(token).getExpiration();
//        return expiration.before(new Date());
//    }
//
//    public boolean validateToken(String token , HttpServletRequest servletRequest){
//        try {
//            Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJwt(token);
//            return  true;
//        } catch (SignatureException ex){
//            log.info("invalid jwt signature");
//        }
//        catch (MalformedJwtException ex){
//            log.info("invalid jwt token");
//        }
//        catch (ExpiredJwtException ex){
//            log.info("expired jwt token");
//            servletRequest.setAttribute("expired",ex.getMessage());
//        }
//        catch (UnsupportedJwtException ex){
//            log.info("unsupported jwt exception");
//        }
//        catch (IllegalArgumentException ex){
//            log.info("jwt claims string is empty");
//        }
//        return false;
//    }
//
//
//}
