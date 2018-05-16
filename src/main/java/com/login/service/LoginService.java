package com.login.service;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.login.dto.LoginDetailsDto;
import com.login.dto.LoginDto;
import com.login.model.TokenDetail;
import com.login.model.UserDetail;
import com.login.repo.TokenRepo;
import com.login.repo.UserRepo;
import com.login.response.Response;
import com.login.token.GenerateToken;
import com.login.util.LoginConstants;


@Service
public class LoginService {

	@Autowired
	private TokenRepo tokenRepo;
	
	@Value("${access_token_Expiry_Time}")
	private Integer accessTokenExpiryTime;
	
	@Value("${refresh_token_Expiry_Time}")
	private Integer refreshTokenExpiryTime;
	
	@Autowired
	private UserRepo userRepo;

	public Response<LoginDetailsDto> login(LoginDto login) {
		Response<LoginDetailsDto> response = new Response<>();
		LoginDetailsDto loginDetails = new LoginDetailsDto();
		UserDetail userDetail = userRepo.findByEmailIgnoreCase(login.getEmail());

		if (userDetail != null ) {
			if (login.getPassword().equals(userDetail.getPassword())) {
				
				loginDetails.setName(userDetail.getFirstName() + " " + userDetail.getLastName());
				loginDetails.setUserId(userDetail.getUserId());
				addTokenDetails(loginDetails, userDetail);
				response.setData(loginDetails);
				response.setMessage(LoginConstants.LOGIN_SUCCESS);
				response.setStatus(HttpServletResponse.SC_OK);
				

			} else {
				setBadRequestResponse(response, LoginConstants.NOT_MATCH);
			}
		} else {
			setBadRequestResponse(response, LoginConstants.BAD_CREDENTIALS);
		}
		return response;
	}

	/**
	 * A method to set Bad Request Response by LoginDetailsDto Object with status
	 * and message Function to add status and message information to the
	 * HttpServletResponse.
	 * 
	 * @param response
	 *            HttpResponse
	 * @param message
	 *            Error message
	 */
	private void setBadRequestResponse(Response<LoginDetailsDto> response, String message) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		response.setMessage(message);
	}

	/**
	 * A function to add token to redis server for validation Method to add token
	 * details with login informations with slugname, role and userId details.
	 * 
	 * @param loginDetails
	 *            have slugname, role, token, userId details
	 * @param userDetail
	 *            will have user details
	 */
	@Transactional
	private void addTokenDetails(LoginDetailsDto loginDetails, UserDetail userDetail) {
		TokenDetail tokenDetail = new TokenDetail();
		tokenDetail.setClientIp("");
		tokenDetail.setUserId(userDetail.getUserId());
		tokenDetail.setAccessTokenExpiryTime(LocalDateTime.now().plusMinutes(accessTokenExpiryTime));
		tokenDetail.setRefreshTokenExpiryTime(LocalDateTime.now().plusMinutes(refreshTokenExpiryTime));
		GenerateToken.generateToken(tokenDetail);
		tokenRepo.save(tokenDetail);
		loginDetails.setAccessToken(tokenDetail.getAccessToken());
		loginDetails.setRefreshToken(tokenDetail.getRefreshToken());
	}

}
