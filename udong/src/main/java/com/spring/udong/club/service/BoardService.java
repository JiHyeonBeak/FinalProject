package com.spring.udong.club.service;

import java.util.List;

import com.spring.udong.club.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> listBoard(int groupId) throws Exception;
	public int addBoard(BoardVO boardVO) throws Exception;
}
