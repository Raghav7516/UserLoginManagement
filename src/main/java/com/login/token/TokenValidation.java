
package com.login.token;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.login.model.TokenDetail;
import com.login.repo.TokenRepo;

@Component
public class TokenValidation {

	@Autowired
	private TokenRepo tokenRepo;


	public TokenDetail getWebToken(String header) {
		TokenDetail token = tokenRepo.findByAccessToken(header);
		if (token == null)
			return null;
		if (LocalDateTime.now().isAfter(token.getAccessTokenExpiryTime())) {
			tokenRepo.delete(token);
			return null;
		}
		LocalDateTime tokenExtendTime = token.getAccessTokenExpiryTime().minusMinutes(5);
		if (tokenExtendTime.isBefore(LocalDateTime.now())) {
			token.setAccessTokenExpiryTime(LocalDateTime.now().plusMinutes(15));
			tokenRepo.save(token);
		}
		return token;
	}
}
