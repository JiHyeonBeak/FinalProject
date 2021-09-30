package com.spring.udong.club.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.udong.club.vo.ClubVO;

@Repository
public class ClubDAOImpl implements ClubDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertClub(ClubVO clubVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.club.insertClub", clubVO);
		return result;
	}

	@Override
	public int updateClub(String groupid) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
}
