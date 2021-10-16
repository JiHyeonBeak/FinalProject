package com.spring.udong.club.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.udong.club.dao.BoardDAO;
import com.spring.udong.club.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> listBoard(int groupId) throws Exception {
		List<BoardVO> boardList = boardDAO.boardList(groupId);
		return boardList;
	}

	@Override
	public int addBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
