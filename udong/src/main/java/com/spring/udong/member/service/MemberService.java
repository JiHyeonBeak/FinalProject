package com.spring.udong.member.service;

import org.springframework.dao.DataAccessException;

import com.spring.udong.member.vo.MemberVO;

public interface MemberService {
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public int removeMember(String id)throws DataAccessException;
	public int updateMember(String id)throws DataAccessException;
	public MemberVO loginMember(MemberVO memberVO)throws DataAccessException;
}
