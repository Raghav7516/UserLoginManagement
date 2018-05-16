package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.login.model.TokenDetail;
import com.login.repo.TokenRepo;
import com.login.response.Response;
import com.login.token.GenerateToken;

@Service
public class TokenService {
	
	@Autowired
	private TokenRepo tokenRepo;

	@Transactional
	public Response<String> updateAccessToken(String refreshToken) {
		
		Response<String> response=new Response<>();
		
		TokenDetail tokenDetail=tokenRepo.findByRefreshToken(refreshToken);
		
		GenerateToken.generateToken(tokenDetail);
		
		String accessToken=tokenDetail.getAccessToken();
		
		response.setData(accessToken);
		
		return response;
	}

}
