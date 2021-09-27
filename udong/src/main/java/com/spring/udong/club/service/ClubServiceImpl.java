package com.spring.udong.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.udong.club.dao.ClubDAO;
import com.spring.udong.club.vo.ClubVO;

@Service
public class ClubServiceImpl implements ClubService{

	@Autowired
	private ClubDAO clubDAO;
	
	@Override
	public int addClub(ClubVO clubVO) throws DataAccessException {
		return clubDAO.insertClub(clubVO);
	}
}
