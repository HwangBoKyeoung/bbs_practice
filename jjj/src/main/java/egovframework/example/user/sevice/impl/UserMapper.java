package egovframework.example.user.sevice.impl;

import java.util.List;

import egovframework.example.user.sevice.UserVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("userMapper")
public interface UserMapper {
	
	List<UserVO> userSelectList();
	UserVO userSelect(UserVO vo);
	int userInsert(UserVO vo);
	int userDelete(UserVO vo);
	int userUpdate(UserVO vo);
	
//	아이디중복체크 : 0=> 아이디생성가능, 1=> 아이디중복, else=> 아이디입력
	int userIdChk(UserVO vo);
	
//	아이디를 통해 비밀번호 찾기
	UserVO userSelectLogin(UserVO vo);
	
}
