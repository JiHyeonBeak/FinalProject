package com.spring.udong.club.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.udong.club.vo.ClubVO;

public interface ClubDAO {
	public int insertClub(ClubVO clubVO)throws DataAccessException;
	public int updateClub(String groupid)throws DataAccessException;
	public List clubList() throws DataAccessException;
}
