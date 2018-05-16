/*
 * @category Login Management.
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.dto.LoginDetailsDto;
import com.login.dto.LoginDto;
import com.login.response.Response;
import com.login.service.LoginService;

/**
* Controller used to login valid user with proper user name and password.
* And with validation part to check and throw error on invalid users.
* 
* This Controller Class results a response either login success or error.
* A convenience RestController annotation that is itself annotated with link Controller and link ResponseBody.
* 
*/

@RestController
@RequestMapping("/login")
public class LoginController {

	
	@Autowired
	private LoginService loginService;

	@PostMapping()
	public @ResponseBody Response<LoginDetailsDto> login(@Valid @RequestBody LoginDto login) {
		return loginService.login(login);
	}

}
