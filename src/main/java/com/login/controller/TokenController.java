package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.response.Response;
import com.login.service.TokenService;


@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private TokenService tokenService;

	@GetMapping
	public @ResponseBody Response<String> updateBrandIdToToken(@RequestParam String refreshToken) {
		return tokenService.updateAccessToken(refreshToken);
	}
}
