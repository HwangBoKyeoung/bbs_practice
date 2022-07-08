package egovframework.example.user.sevice;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Resource(name="userService")
	private UserService userService;
	
//	단건조회 리턴
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("======================="+username);
		
		UserVO vo = new UserVO();
		vo.setUserId(username);
		System.out.println("***********************"+vo);
		
		UserVO userVO = userService.userSelect(vo);
		System.out.println("-----------------------"+userVO);
		
//		아이디 없을 때
		if(userVO == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		
		return userVO;
	}

}
