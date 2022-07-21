package egovframework.example.user.sevice.impl;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/egovframework/spring/context-*.xml")
public class UserServiceImplTest extends EgovAbstractServiceImpl implements UserService {

	@Resource(name = "userDAO")
	private UserDAO userDAO;
	
	@Value("#{system['my.email']}")
	private String email;
	
	@Value("#{system['my.password']}")
	private String password;

	@Override
	public List<UserVO> userSelectList() {
		return userDAO.userSelectList();
	}

	@Override
	public UserVO userSelect(UserVO vo) {
		return userDAO.userSelect(vo);
	}

	@Override
	public int userInsert(UserVO vo) {
		return userDAO.userInsert(vo);
	}

	@Override
	public int userDelete(UserVO vo) {
		return userDAO.userDelete(vo);
	}

	@Override
	public int userUpdate(UserVO vo) {
		return userDAO.userUpdate(vo);
	}

	@Override
	public int userIdChk(UserVO vo) {
		return userDAO.userIdChk(vo);
	}

	@Override
	public UserVO userSelectLogin(UserVO vo) {
		return userDAO.userSelectLogin(vo);
	}

	@Override
	public int findUserPassword(UserVO vo) {
		return userDAO.findUserPassword(vo);
	}

	@Override
	public void sendEmail(UserVO vo, String div) {
		// Mail Server 설정
		String charSet = "utf-8";

		String hostSMTP = null;
		if (vo.getUserMail().contains("@naver.com")) {
			hostSMTP = "smtp.naver.com";
		} else if (vo.getUserMail().contains("@gmail.com")) {
			hostSMTP = "smtp.gmail.com";
		} else {
			return;
		}

		String hostSMTPid = email;
		String hostSMTPpwd = password;

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "forwiz@forwiz.com";
		String fromName = "포위즈게시판실습생";
		String subject = "";
		String msg = "";

		if (div.equals("findPwd")) {
			subject = "포위즈게시판 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += vo.getUserMail() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += vo.getUserRePwd()+ "</p></div>";
		}

		// 받는 사람 E-Mail 주소
		String mail = vo.getUserMail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);

			if (vo.getUserMail().contains("@naver.com")) {
				email.setSmtpPort(587);
			} else if (vo.getUserMail().contains("@gmail.com")) {
				email.setSmtpPort(465);
			} else {
				return;
			}

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}

	@Override
	public void findPwd(HttpServletResponse resp, UserVO vo) throws Exception {
		resp.setContentType("text/html;charset=utf-8");
		UserVO ck = userDAO.userSelectLogin(vo);
		PrintWriter out = resp.getWriter();
		// 가입된 아이디가 없으면
		if (ck == null) {
			out.print("등록되지 않은 아이디입니다.");
			out.close();
		}
		// 가입된 이메일이 아니면
		else if (!vo.getUserMail().equals(ck.getUserMail())) {
			out.print("등록되지 않은 이메일입니다.");
			out.close();
		} else {
			// 임시 비밀번호 생성
			String pw = "";
			for (int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			vo.setUserRePwd(pw);
			// 비밀번호 변경
			userDAO.findUserPassword(vo);
			// 비밀번호 변경 메일 발송
			sendEmail(vo, "findPwd");

			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			out.close();
		}

	}
}
