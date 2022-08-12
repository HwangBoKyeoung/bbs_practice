package egovframework.example.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.user.service.UserService;
import egovframework.example.user.service.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDAO")
	private UserDAO userDAO;

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
	public int userUpdate(UserVO vo) {
		return userDAO.userUpdate(vo);
	}

	@Override
	public int userDelete(UserVO vo) {
		return userDAO.userDelete(vo);
	}

}
