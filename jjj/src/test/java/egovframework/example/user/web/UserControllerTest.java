package egovframework.example.user.web;


import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/egovframework/spring/context-*.xml")
public class UserControllerTest {
	
	@Resource(name="userService")
	private UserService userService;
	
	/*@Resource(name="naverMailSender")
	private JavaMailSender naverMailSender;*/
	
//	유효성 검사 테스트
//	@Test
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
	
//	메일 전송 테스트
//	@Test
	public void userPasswordTest() throws Exception {
		ServletWebRequest servletContainer = (ServletWebRequest)RequestContextHolder.getRequestAttributes();
		HttpServletResponse resp = servletContainer.getResponse();
			
		UserVO vo = new UserVO();
		
		vo.setUserId("test1");
		vo.setUserMail("lier723441@gmail.com");
		userService.findPwd(resp, vo);
		String newPwd = vo.getUserRePwd();
		//liadymetzzwv
		//bbamsflmnqsy
		System.out.println("====================임시비밀번호: "+newPwd);
	}
	
//	임시비밀번호 생성 테스트
//	@Test
	public String userTemporaryPasswordTest() {
		String pw = "";
		for (int i = 0; i < 12; i++) {
			// 임시비밀번호에 12자리 문자가 들어갈 것
			pw += (char) ((Math.random() * 26) + 97);
		}
		// 임시비밀번호에 1~100까지 숫자 들어가기
		pw += (int) ((Math.random() * 100) + 1);
		
		System.out.println("=======================임시비밀번호: " + pw);
		return pw;
	}
	
//	메일발송 테스트
//	@Test
	public void sendMail() throws MailException, MalformedURLException {
		try {
			HtmlEmail email = new HtmlEmail();
			
			// 메일정보
			email.setHostName("smtp.naver.com");
			email.setSmtpPort(587);
			email.setAuthentication("naru1780@naver.com", "naruto1010*");
			email.addTo("naru1780@naver.com", "naruto1010*");
			email.setFrom("naru1780@naver.com", "naruto1010*");
			email.setSubject("임시비밀번호 전송 메일입니다.");
			
			// 삽입할 이미지
			URL url = new URL("https://www.apache.org/images/asf_logo_wide.gif");
			String cid = email.embed(url, "아파치 로고");
			
			// 전송할 임시비밀번호
			String pwd = userTemporaryPasswordTest();
			
			// HTML 메세지
			email.setHtmlMsg("<html>"
						   + "<h1>임시비밀번호를 전송합니다.</h1>"
						   + "<h2>"+ pwd +"</h2>"
						   + "<img src='" + cid + "'>"
						   + "</html>");
			
			// html이메일을 지원하지 않는 클라이언트라면, 다음 메세지를 뿌려줌
			email.setTextMsg("HTML을 지원하지 않는 클라이언트입니다.");
			
			// 이메일 전송
			email.send();
		} catch(EmailException e) {
			e.printStackTrace();
		}
		
	}
	
//	주민등록번호 유효성 검사
//	@Test
	public void ihIdNumTest() {
		String str = "111140-1111111";
		UserVO vo = new UserVO();
		boolean test = vo.isPersonalId(str);
		
		System.out.println("주민등록번호 유효성 테스트 =>========================="+test);
	}
	
//	비밀번호 null값 update
//	@Test
	public void pwdUpdateTest() {
		UserVO vo = new UserVO();
		vo.setUserPwd(null);
		if(vo.getUserPwd() != null) {
			System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
			String pwd = encoder.encode(vo.getUserPwd());
			vo.setUserPwd(pwd);
		} else {
			System.out.println("ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ");
			vo.setUserPwd(null);
		}
		
		System.out.println("userPwd값============================"+vo.getUserPwd());
	}
	
	@Test
	public void bcryptTest() {
		String p1 = "$2a$10$Rtu7WzzuYxcRLVx9vfRzwu7PPslBpaUXBjDndP.vdIcBIgqZnXB.m";
		String p2 = "ghkdqhrud11*";
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String p3 = encoder.encode(p2);
		
		System.out.println("============================="+encoder.matches(p1, p3));
		
	}
	
}
