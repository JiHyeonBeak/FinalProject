package com.spring.udong.club.dao;

import org.springframework.dao.DataAccessException;

import com.spring.udong.club.vo.ClubVO;

public interface ClubDAO {
	public int insertClub(ClubVO clubVO)throws DataAccessException;
}