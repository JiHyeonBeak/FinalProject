package com.spring.udong.club.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.udong.club.vo.BoardVO;

public interface BoardDAO {
	public List boardList(int groupId) throws DataAccessException;
	public int insertBoard(BoardVO boardVO)throws DataAccessException;

}
