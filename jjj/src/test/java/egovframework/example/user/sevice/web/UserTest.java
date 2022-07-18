package egovframework.example.user.sevice.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/egovframework/spring/context-*.xml")
public class UserTest {

	/*@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	*/
	@Test
	public void test() {
		String pwd = "1234";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String encPwd = encoder.encode(pwd);

		System.out.println("=================================="+pwd);
		System.out.println("=================================="+encPwd);
	}
	
}
