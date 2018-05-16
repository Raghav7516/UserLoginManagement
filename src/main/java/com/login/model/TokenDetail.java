/*
 * @category GateWay Token Management.
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.login.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A container class to store and retrieve informations from database tables.
 * This include token details with token expire time limit range.
 *
 */

@Entity
@Table(name = "token_details")
public class TokenDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6576324953564602096L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TOKEN_ID")
	private Integer tokenId;

	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "ACCESS_TOKEN")
	private String accessToken;
	
	@Column(name = "REFRESH_TOKEN")
	private String refreshToken;

	@Column(name = "CLIENT_IP")
	private String clientIp;

	@Column(name = "ACCESS_TOKEN_EXPIRY_TIME")
	private LocalDateTime accessTokenExpiryTime;
	
	@Column(name = "REFRESH_TOKEN_EXPIRY_TIME")
	private LocalDateTime refreshTokenExpiryTime;

	public Integer getTokenId() {
		return tokenId;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public LocalDateTime getAccessTokenExpiryTime() {
		return accessTokenExpiryTime;
	}

	public void setAccessTokenExpiryTime(LocalDateTime accessTokenExpiryTime) {
		this.accessTokenExpiryTime = accessTokenExpiryTime;
	}

	public LocalDateTime getRefreshTokenExpiryTime() {
		return refreshTokenExpiryTime;
	}

	public void setRefreshTokenExpiryTime(LocalDateTime refreshTokenExpiryTime) {
		this.refreshTokenExpiryTime = refreshTokenExpiryTime;
	}


}
