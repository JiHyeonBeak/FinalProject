package com.spring.udong.club.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.udong.club.vo.CommentVO;
import com.spring.udong.club.vo.PageVO;

@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO{
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private CommentVO commentVO;
	@Autowired
	private PageVO pageVO;

	@Override
	public List CommentList(PageVO pageVO) throws DataAccessException {
		List<CommentVO> commentList = sqlSession.selectList("mapper.comment.commentPaging",pageVO);
		System.out.println(commentList);
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

	@Override
	public List modList(int articleNo) throws DataAccessException {
		List modList = sqlSession.selectList("mapper.comment.modList",articleNo);
		return modList;
	}

	@Override
	public int countComment() {
		int result = sqlSession.selectOne("mapper.comment.countComment");
		return result;
	}

}
