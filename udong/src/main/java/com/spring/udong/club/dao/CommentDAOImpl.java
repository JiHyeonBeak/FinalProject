package com.spring.udong.club.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.udong.club.vo.CommentVO;

@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List CommentList() throws DataAccessException {
		List<CommentVO> commentList = sqlSession.selectList("mapper.comment.commentList");
		return commentList;
	}

	@Override
	public int insertComment(CommentVO commentVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.comment.addComment", commentVO);
		return result;
	}

	@Override
	public int deleteComment(int articleNo) throws DataAccessException {
		int result = sqlSession.delete("mapper.comment.delComment", articleNo);
		return result;
	}

	@Override
	public int modComment(int articleNo) throws DataAccessException {
		int result = sqlSession.update("mapper.comment.modComment", articleNo);
		return result;
	}

	@Override
	public int like(int articleNo) throws DataAccessException {
		int result = sqlSession.update("mapper.comment.like", articleNo);
		return result;
	}

}
