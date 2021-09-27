package com.spring.udong.club.service;

import org.springframework.dao.DataAccessException;

import com.spring.udong.club.vo.ClubVO;

public interface ClubService {
	public int addClub(ClubVO clubVO) throws DataAccessException;
}
