package egovframework.example.user.service.impl;

import java.util.List;

import egovframework.example.user.service.UserVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("userMapper")
public interface UserMapper {

	List<UserVO> userSelectList();
	UserVO userSelect(UserVO vo);
	int userInsert(UserVO vo);
	int userUpdate(UserVO vo);
	int userDelete(UserVO vo);
	
}
