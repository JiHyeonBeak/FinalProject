package com.spring.udong.club.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.udong.club.vo.ClubVO;
import com.spring.udong.club.vo.CommentVO;
import com.spring.udong.club.vo.JoinVO;
import com.spring.udong.member.vo.MemberVO;

@Repository
public class ClubDAOImpl implements ClubDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertClub(ClubVO clubVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.club.insertClub", clubVO);
		sqlSession.selectList("insertClubMember",clubVO);
		sqlSession.selectList("addClubBoard",clubVO);
		sqlSession.insert("mapper.club.insertLeader",clubVO);
		sqlSession.insert("mapper.club.joinClubLeader",clubVO);
		return result;
	}

	@Override
	public List clubList() throws DataAccessException {
		List<ClubVO> clubList = sqlSession.selectList("mapper.club.clubList");
		return clubList;
	}

	@Override
	public int joinClub(JoinVO joinVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.club.joinClubMem",joinVO);
		sqlSession.insert("mapper.club.joinClubclub",joinVO);
		return result;
	}

	@Override
	public List<ClubVO> joinList(MemberVO memberVO) throws DataAccessException {
		List joinList = (ArrayList)sqlSession.selectList("mapper.club.getJoinList",memberVO);
		List<ClubVO> getJoinList = new ArrayList<ClubVO>();
		for(int i=0 ; i < joinList.size() ; i++) {
			String name = (String) joinList.get(i);
			List<ClubVO> joinName = new ArrayList<ClubVO>();
			joinName = sqlSession.selectList("mapper.club.JoinList",name);
			getJoinList.addAll(joinName);
		}
		return getJoinList;
	}
}
