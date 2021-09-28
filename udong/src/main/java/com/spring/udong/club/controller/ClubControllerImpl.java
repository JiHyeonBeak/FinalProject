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
		mav.setViewName("redirect:/club/main");
		return mav;
	}

	@Override
	@RequestMapping(value= "/club/addComment", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addComment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		int result=0;
		result = commentService.addComment(commentVO);
		System.out.println("addComment 실행");
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
	public ModelAndView deleteComment(int article_no, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
