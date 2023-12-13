package com.application.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String checkAdminRole() {
		return "Logged In with Admin role";
	}

	@GetMapping("/user")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String checkUserRole() {
		return "Logged In with User role";
	}

}
