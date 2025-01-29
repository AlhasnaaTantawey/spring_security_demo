package com.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.dto.ErrorResponseDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());

        // Set HTTP response status to 401 (Unauthorized)
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");

        // Create a custom error response
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                "Unauthorized: Authentication is required.",
                authException.getMessage()
        );

        // Write the error response as JSON
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }

}
