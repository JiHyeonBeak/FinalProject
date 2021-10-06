package com.spring.udong.club.service;

import java.util.List;
import java.util.Map;

import com.spring.udong.club.vo.CommentVO;

public interface CommentService {
	public List<CommentVO> listComment() throws Exception;
	public int addComment(CommentVO commentVO) throws Exception;
	public int deleteComment(int articleNo) throws Exception;
	public int modComment(int articleNo) throws Exception;
	public int like(int articleNo) throws Exception;
}
