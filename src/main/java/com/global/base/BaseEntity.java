package com.global.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity<ID> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;

	private String statusCode;

	@CreatedBy
	private String createdBy;

	@CreatedDate
	private LocalDateTime createdData;

	@LastModifiedBy
	private String lastModifiedBy;

	@LastModifiedDate
	private LocalDateTime lastModifiedData;

	public ID getId() {
		return id;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public LocalDateTime getCreatedData() {
		return createdData;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public LocalDateTime getLastModifiedData() {
		return lastModifiedData;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedData(LocalDateTime createdData) {
		this.createdData = createdData;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public void setLastModifiedData(LocalDateTime lastModifiedData) {
		this.lastModifiedData = lastModifiedData;
	}
}
