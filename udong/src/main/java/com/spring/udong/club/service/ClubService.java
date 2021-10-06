package com.spring.udong.club.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.udong.club.vo.ClubVO;
import com.spring.udong.club.vo.CommentVO;

public interface ClubService {
	public int addClub(ClubVO clubVO) throws DataAccessException;
	public List<ClubVO> clubList() throws Exception;
}
