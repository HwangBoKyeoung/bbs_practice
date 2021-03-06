package egovframework.example.user.sevice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import egovframework.example.user.sevice.SampleUser;
import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = new UserVO();
		vo.setUserId(username);
		UserVO user = userService.userSelectLogin(vo);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(user.getRole()));
		
		return new SampleUser(username, user.getUserPwd(), auth);
	}

}
