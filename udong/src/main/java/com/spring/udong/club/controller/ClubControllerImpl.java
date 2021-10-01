package com.spring.udong.club.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.udong.club.service.ClubService;
import com.spring.udong.club.service.CommentService;
import com.spring.udong.club.vo.ClubVO;
import com.spring.udong.club.vo.CommentVO;

@Controller("clubController")
public class ClubControllerImpl implements ClubController{
	@Autowired
	private CommentService commentService;
	@Autowired
	private CommentVO commentVO;
	@Autowired
	private ClubService clubService;
	
	@RequestMapping(value="/club/main", method=RequestMethod.GET)
		public String main(Locale locale, Model model) {
			return"clubMain";
		}
	
	@RequestMapping(value="club/add", method=RequestMethod.GET)
	public String addClub(Locale locale, Model model) {
		return "createClub";
	}
	
	@Override
	@RequestMapping(value= "/club/listComment", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		List commentList = commentService.listComment();
		mav.addObject("commentList",commentList);
		mav.setViewName("clubMain");
		return mav;
	}

	@Override
	@RequestMapping(value= "/club/addComment", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addComment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		int result=0;
		String title = request.getParameter("articleTitle");
		String content = request.getParameter("articleContent");
		commentVO.setArticleTitle(title);
		commentVO.setArticleContent(content);
		result = commentService.addComment(commentVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/club/listComment");
		return mav;
	}

	@Override
	@RequestMapping(value="/club/addClub",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addClub(ClubVO clubVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			request.setCharacterEncoding("utf-8");
			int result = 0;
			result = clubService.addClub(clubVO);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("login");
			return mav;
	}

	@Override
	@RequestMapping(value="/club/delComment",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteComment(int articleNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println(commentVO.getArticleNo());
		commentService.deleteComment(commentVO);
		System.out.println(commentVO.getArticleContent());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/club/listComment");
		return mav;
	}
	

}
