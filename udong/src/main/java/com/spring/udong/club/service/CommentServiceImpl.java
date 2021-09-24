package com.spring.udong.club.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.udong.club.dao.CommentDAO;
import com.spring.udong.club.vo.CommentVO;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentDAO commentDAO;

	@Override
	public List<CommentVO> listComment() throws Exception {
		List<CommentVO> commentList = commentDAO.CommentList();
		return commentList;
	}

	@Override
	public int addComment(CommentVO commentVO) throws Exception {
		return commentDAO.insertComment(commentVO);
	}

}