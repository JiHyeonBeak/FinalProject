package com.spring.udong.join.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.udong.join.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllMember() throws DataAccessException {
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMember");
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insetMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.update("mapper.member.updateMember", memberVO);
		return result;
	}

//	@Override
//	public MemberVO loginById(MemberVO memberVO) throws DataAccessException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}