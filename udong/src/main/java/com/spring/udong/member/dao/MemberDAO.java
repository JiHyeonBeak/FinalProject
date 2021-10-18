package com.spring.udong.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.udong.member.vo.MemberVO;

public interface MemberDAO{
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
	public int updateMember(MemberVO memberVO) throws DataAccessException;
	public MemberVO loginMember(MemberVO memberVO) throws DataAccessException;
	public int joinCheck(MemberVO memberVO)throws DataAccessException;
}
