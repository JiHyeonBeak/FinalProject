package com.spring.udong.club.service;

import java.util.List;

import com.spring.udong.club.vo.BoardVO;
import com.spring.udong.club.vo.JoinVO;

public interface BoardService {
	public List<BoardVO> listBoard(JoinVO joinVO) throws Exception;
	public int addBoard(BoardVO boardVO) throws Exception;
}
