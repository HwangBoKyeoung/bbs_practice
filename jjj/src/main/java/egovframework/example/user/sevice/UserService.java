package egovframework.example.user.sevice;

import java.util.List;

import javax.servlet.http.HttpServletResponse;


public interface UserService {
	
	List<UserVO> userSelectList();
	UserVO userSelect(UserVO vo);
	int userInsert(UserVO vo);
	int userDelete(UserVO vo);
	int userUpdate(UserVO vo);
	
//	아이디중복체크 : 0=> 아이디생성가능, 1=> 아이디중복, else=> 아이디입력
	int userIdChk(UserVO vo);
	
//	security 로그인정보
	UserVO userSelectLogin(UserVO vo);
	
//	비밀번호 update
	int findUserPassword(UserVO vo);
	
//	이메일발송 메서드
	void sendEmail(UserVO vo, String div);
	
//	비밀번호 찾기
	void findPwd(HttpServletResponse resp, UserVO vo) throws Exception;
}
