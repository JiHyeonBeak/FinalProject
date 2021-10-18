package com.spring.udong.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.udong.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		sqlSession.insert("mapper.member.joinList", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		sqlSession.update("mapper.member.dropMember",id);
		return result;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.update("mapper.member.updateMember",memberVO);
		return result;
	}

	@Override
	public MemberVO loginMember(MemberVO memberVO) throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.loginMember",memberVO);
		return vo;
	}

	@Override
	public int joinCheck(MemberVO memberVO) throws DataAccessException {
		String id = memberVO.getId();
		System.out.println(id);
		int result = 0;
		memberVO = sqlSession.selectOne("mapper.member.joinCheck",id);
		if(memberVO != null) {
			result = 0;
		}else {
			result = 1 ;
		}
		return result;
	}


}
