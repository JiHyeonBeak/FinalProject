package com.spring.udong.club.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.udong.club.vo.BoardVO;
import com.spring.udong.club.vo.JoinVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List boardList(JoinVO joinVO) throws DataAccessException {
		List<BoardDAO> boardList = sqlSession.selectList("mapper.board.boardList",joinVO);
		return boardList;
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
