package com.spring.udong.join.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.udong.join.vo.MemberVO;

public interface MemberDAO {
	public List selectAllMember() throws DataAccessException;
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
	public int updateMember(MemberVO memberVO) throws DataAccessException;
//	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
	

}
