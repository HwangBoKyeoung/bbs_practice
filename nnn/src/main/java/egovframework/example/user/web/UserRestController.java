package egovframework.example.user.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import egovframework.example.user.service.UserService;

@RestController
public class UserRestController {

	@Resource(name="userService")
	private UserService userService;
	
}
