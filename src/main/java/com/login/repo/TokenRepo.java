
package com.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.model.TokenDetail;

@Repository
public interface TokenRepo extends JpaRepository<TokenDetail, Integer> {
	
	TokenDetail findByRefreshToken(String token);
	
	TokenDetail findByAccessToken(String token);
	
}
