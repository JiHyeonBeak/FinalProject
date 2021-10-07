package com.spring.udong.club.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.udong.club.vo.CommentVO;

public interface CommentDAO {
	public List CommentList() throws DataAccessException;
	public int insertComment(CommentVO commentVO)throws DataAccessException;
	public int deleteComment(int articleNo)throws DataAccessException;
	public int modComment(int articleNo)throws DataAccessException;
	public int like(int articleNo)throws DataAccessException;
	public int dislike(int articleNo)throws DataAccessException;

}
