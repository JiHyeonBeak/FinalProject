package com.spring.udong.club.service;

import java.util.List;
import java.util.Map;

import com.spring.udong.club.vo.CommentVO;
import com.spring.udong.club.vo.PageVO;

public interface CommentService {
	public List<CommentVO> listComment(PageVO pageVO) throws Exception;
	public int addComment(CommentVO commentVO) throws Exception;
	public int deleteComment(int articleNo) throws Exception;
	public int modComment(int articleNo) throws Exception;
	public List<CommentVO> modList(int articleNo) throws Exception;
	public int like(int articleNo) throws Exception;
	public int countComment() throws Exception;
}
