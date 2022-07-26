package egovframework.example.user.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import egovframework.example.user.sevice.UserVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/egovframework/spring/context-*.xml")
public class UserControllerTest {
	
	@Test
	public void userInsertTest() {
		UserVO userVO = new UserVO();
		
		// 영어+숫자 검사 (6자리~12자리)
		String str = "aa"; // false
		str = "aaaaaa"; //true
		str = "aaaaaaaaaaaaa"; //false
		boolean a = userVO.isAlphaNumber(str);
		
		System.out.println("============테스트용 유효성검사 결과=>" + str + "= "+ a);
		
		// 아이디 검사
		// 시작은 영문으로만, '_'를 제외한 특수문자 안되며 영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하
		str = "abcdefghijk";
		boolean b = userVO.isId(str);
		
		System.out.println("============아이디 유효성검사 결과=>" + str + "= "+ b);
		
	}
	
	
}
