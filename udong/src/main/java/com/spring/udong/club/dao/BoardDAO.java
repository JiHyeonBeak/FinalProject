package com.spring.udong.club.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.udong.club.vo.BoardVO;
import com.spring.udong.club.vo.JoinVO;

public interface BoardDAO {
	public List boardList(JoinVO joinVO) throws DataAccessException;
	public int insertBoard(BoardVO boardVO)throws DataAccessException;

}
