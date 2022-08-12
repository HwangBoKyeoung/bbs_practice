package egovframework.example.user.service;

import java.util.List;

public interface UserService {
	
	List<UserVO> userSelectList();
	UserVO userSelect(UserVO vo);
	int userInsert(UserVO vo);
	int userUpdate(UserVO vo);
	int userDelete(UserVO vo);
	
}
