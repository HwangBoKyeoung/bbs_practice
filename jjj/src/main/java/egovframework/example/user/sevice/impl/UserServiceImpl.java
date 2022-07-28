package egovframework.example.user.sevice.impl;

import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import egovframework.example.user.sevice.UserService;
import egovframework.example.user.sevice.UserVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("userService")
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService {

	@Resource(name = "userDAO")
	private UserDAO userDAO;
	
	@Value("#{system['emailAddr']}")
	private String emailAddr;
	
	@Value("#{system['emailPassword']}")
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
	public void sendEmail(UserVO vo, String div) throws MailException, MalformedURLException {
		String charSet = "UTF-8" ;
		try {
			HtmlEmail email = new HtmlEmail();
			
			String hostSMTP = null;
			if (vo.getUserMail().contains("@naver.com")) {
				hostSMTP = "smtp.naver.com";
			} else if (vo.getUserMail().contains("@gmail.com")) {
				hostSMTP = "smtp.gmail.com";
			} else {
				hostSMTP = null;
			}
			
			System.out.println(vo.getUserMail());
			// 메일정보
			email.setHostName(hostSMTP);
			email.setSmtpPort(587);
			email.setSSL(true);
			email.setAuthentication(emailAddr, password);
			email.addTo(vo.getUserMail(), vo.getUsername()+"님", "utf-8");
			email.setFrom(emailAddr, "포위즈게시판");
			email.setCharset(charSet);
			email.setSubject("임시비밀번호 전송===포위즈===");
			
			// HTML 메세지
			email.setHtmlMsg("<html>"
						   + "<h1>임시비밀번호를 전송합니다.</h1>"
						   + "<h2>"+ vo.getUserRePwd() +"</h2>"
						   + "</html>");
			
			// html이메일을 지원하지 않는 클라이언트라면, 다음 메세지를 뿌려줌
			email.setTextMsg("HTML을 지원하지 않는 클라이언트입니다.");
			
			// 이메일 전송
			String success = email.send();
			System.out.println("**********************이메일전송 결과 : "+success);
		} catch(EmailException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void findPwd(HttpServletResponse resp, UserVO vo) throws Exception {
		resp.setContentType("text/html;charset=utf-8");
		UserVO ck = userDAO.userSelectLogin(vo);
		PrintWriter out = resp.getWriter();
		// 가입된 아이디가 없으면
		if (ck == null) {
			out.print("");
			out.close();
		}
		// 가입된 이메일이 아니면
		else if (!vo.getUserMail().equals(ck.getUserMail())) {
			out.print("");
			out.close();
		} else {
			// 임시 비밀번호 생성
			String pw = "";
			
			for (int i = 0; i < 12; i++) {
				// 임시비밀번호에 12자리 문자가 들어갈 것
				pw += (char) ((Math.random() * 26) + 97);
			}
			
			// 임시비밀번호에 1~100까지 숫자 들어가기
			pw += (int) ((Math.random() * 100) + 1);
			
			// userRePwd에는 임시비밀번호를 그대로 저장
			vo.setUserRePwd(pw);
			
			// 비밀번호 암호화, userPwd에는 임시비밀번호를 암호화해서 저장
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
			String result = encoder.encode(vo.getUserRePwd());
			vo.setUserPwd(result);
			
			// 비밀번호 변경
			int r = userDAO.findUserPassword(vo);
			if(r <= 0) {
				out.print("");
			}
			
			// 비밀번호 변경 메일 발송
			sendEmail(vo, "findPwd");
			
			out.print(vo.getUserRePwd());
			out.close();
		}

	}

//	이메일로 아이디찾기 (임시비밀번호 변경을 위해 필요)
	@Override
	public String findUserIdByMail(String mail) {
		return userDAO.findUserIdByMail(mail);
	}
	
}
