package com.nt.ozod.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.ozod.controller.dto.UserDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	private static List<UserDto> users = new ArrayList<>();

	static {
		users.add(new UserDto("test1", "pass1", "Raja"));
		users.add(new UserDto("test2", "pass2", "Ram"));
		users.add(new UserDto("test3", "pass3", "Mangal"));
	}

	@GetMapping("/msg")
	public String msg() {
		return "Retest";
	}

	@GetMapping("/login/{userName}/{pass}")
	public UserDto login(@PathVariable String userName, @PathVariable String pass) {
		if (!ObjectUtils.isEmpty(userName) && !ObjectUtils.isEmpty(pass)) {
			for (UserDto user : users) {
				if (user.getUserName().equals(userName) && user.getPassword().equalsIgnoreCase(pass)) {
					return user;
				}
			}
		}
		return null;
	}

}
