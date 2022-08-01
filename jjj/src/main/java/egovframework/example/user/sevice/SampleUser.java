package egovframework.example.user.sevice;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

//	User객체에 저장될 값 => CustomUserDetailsService.java에서 리턴될 값
public class SampleUser extends User {

	private static final long serialVersionUID = 1L;
	private UserVO user;

	public SampleUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public SampleUser(UserVO vo) {
		super(vo.getUserId(), vo.getUserPwd(), vo.getAuthorities());
		this.user = vo;
	}

}
