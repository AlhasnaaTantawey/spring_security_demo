package com.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ErrorResponseDto {

//	private LocalDateTime timestamp;
	private String message;
	private String details;

	public ErrorResponseDto(String message, String details) {
		this.message = message;
		this.details = details;
	}
}
