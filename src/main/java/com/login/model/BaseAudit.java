package com.login.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseAudit implements Serializable {

	private static final long serialVersionUID = 5830142284582005685L;

	@Column(name = "CREATED_BY")
	private Integer createdBy;

	@Column(name = "CREATED_AT")
	private Long createdAt;

	@Column(name = "UPDATED_BY")
	private Integer updatedBy;

	@Column(name = "UPDATED_AT")
	private Long updatedAt;

	@Column(name = "DELETED_BY")
	private Integer deletedBy;

	@Column(name = "DELETED_AT")
	private Long deletedAt;

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Long getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Long deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	

}
