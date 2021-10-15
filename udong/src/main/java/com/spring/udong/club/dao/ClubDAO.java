package com.spring.udong.club.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.udong.club.vo.ClubVO;
import com.spring.udong.club.vo.JoinVO;
import com.spring.udong.member.vo.MemberVO;

public interface ClubDAO {
	public int insertClub(ClubVO clubVO)throws DataAccessException;
	public List clubList() throws DataAccessException;
	public int joinClub(JoinVO joinVO)throws DataAccessException;
	public List<ClubVO> joinList(MemberVO memberVO) throws DataAccessException;
}
