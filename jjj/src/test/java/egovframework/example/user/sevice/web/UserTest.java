package egovframework.example.user.sevice.web;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/egovframework/spring/context-*.xml")
public class UserTest {

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Test
	public void test() {
		String pwd = "1234";
		String encPwd = bcryptPasswordEncoder.encode(pwd);

		System.out.println("=================================="+pwd);
		System.out.println("=================================="+encPwd);
	}
	
	@Test
	public void loginTest() {
		UserVO vo = new UserVO();
		vo.setUserId("sample1");
		vo = userService.userSelectLogin(vo);
		System.out.println("----------------------------------"+vo.getUserPwd());
	}
}
