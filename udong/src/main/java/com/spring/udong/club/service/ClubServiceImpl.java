package com.spring.udong.club.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.udong.club.dao.ClubDAO;
import com.spring.udong.club.vo.ClubVO;
import com.spring.udong.club.vo.JoinVO;
import com.spring.udong.member.vo.MemberVO;

@Service
public class ClubServiceImpl implements ClubService{
	@Autowired
	private ClubDAO clubDAO;
	
	@Override
	public int addClub(ClubVO clubVO) throws DataAccessException {
		return clubDAO.insertClub(clubVO);
	}

	@Override
	public List<ClubVO> clubList() throws Exception {
		return clubDAO.clubList();
	}

	@Override
	public int joinClub(JoinVO joinVO) throws DataAccessException {
		return clubDAO.joinClub(joinVO);
	}

	@Override
	public List joinList(MemberVO memberVO) throws Exception {
		return clubDAO.joinList(memberVO);
	}
}
