package egovframework.example.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.example.user.service.UserVO;

@Repository("userDAO")
public class UserDAO {
	
	@Resource(name="sqlSession")
	private SqlSession query;
	
	private static final String namespace = "userMapper.";

	List<UserVO> userSelectList(){
		return query.selectList(namespace+"userSelectList");
	}
	
	UserVO userSelect(UserVO vo) {
		return query.selectOne(namespace+"userSelect", vo);
	}
	
	int userInsert(UserVO vo) {
		return query.insert(namespace+"userInsert", vo);
	}
	
	int userUpdate(UserVO vo) {
		return query.update(namespace+"userUpdate", vo);
	}
	
	int userDelete(UserVO vo) {
		return query.delete(namespace+"userDelete", vo);
	}
	
}
