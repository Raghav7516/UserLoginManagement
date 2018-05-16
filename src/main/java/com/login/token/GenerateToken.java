
package com.login.token;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import com.auth0.jwt.Algorithm;
import com.auth0.jwt.JWTSigner;
import com.login.model.TokenDetail;


public class GenerateToken {
	
	@Value("${access_token_Expiry_Time}")
	private Integer accessTokenExpiryTime;
	
	@Value("${refresh_token_Expiry_Time}")
	private Integer refreshTokenExpiryTime;

	private GenerateToken() {
	}

/*	public static TokenDetail generateToken(TokenDetail tokenDetail) {
		JWTSigner signer = new JWTSigner("oem_daimler_Gateway");
		Map<String, Object> claims = new HashMap<>();
		claims.put("user", tokenDetail.getUserId());
		JWTSigner.Options option = new JWTSigner.Options();
		option.setAlgorithm(Algorithm.HS256);
		option.setIssuedAt(true);
		option.setJwtId(true);
		option.setNotValidBeforeLeeway(3);
		tokenDetail.setAccessToken(signer.sign(claims, option));
		tokenDetail.setRefreshToken(signer.sign(claims, option));
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, 15);
		return tokenDetail;
	}*/
	public static TokenDetail generateToken(TokenDetail tokenDetail) {
				UUID uuid = UUID.randomUUID();
				 String randomUUIDString = uuid.toString();
				tokenDetail.setAccessToken(randomUUIDString);
				if (tokenDetail.getRefreshToken()==null) {
					tokenDetail.setRefreshToken(randomUUIDString);
				} else {
					tokenDetail.setRefreshToken(tokenDetail.getRefreshToken());
				}
				Calendar now = Calendar.getInstance();
				now.add(Calendar.MINUTE, 15);
				System.out.println(randomUUIDString);
				
			return tokenDetail;
	}

}
