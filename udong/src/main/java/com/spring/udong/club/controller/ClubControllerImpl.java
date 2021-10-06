package com.spring.udong.club.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.udong.club.service.ClubService;
import com.spring.udong.club.service.CommentService;
import com.spring.udong.club.vo.ClubVO;
import com.spring.udong.club.vo.CommentVO;
import com.spring.udong.member.vo.MemberVO;

@Controller("clubController")
public class ClubControllerImpl implements ClubController{
	@Autowired
	private CommentService commentService;
	@Autowired
	private CommentVO commentVO;
	@Autowired
	private ClubService clubService;
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping(value="/club/home", method=RequestMethod.GET)
	public String clubHome(Locale locale, Model model) {
		return"clubHome";
	}
	
	@RequestMapping(value="/club/joinClub", method=RequestMethod.GET)
	public String joinClub(Locale locale, Model model) {
		return"joinClub";
	}
	
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
		HttpSession session = request.getSession();
		String title = request.getParameter("articleTitle");
		String content = request.getParameter("articleContent");
		memberVO = (MemberVO)session.getAttribute("member");
		String id = memberVO.getId();
		System.out.println("클럽콘트롤러 상 id: "+id);
		commentVO.setArticleTitle(title);
		commentVO.setArticleContent(content);
		commentVO.setArticleId(id);
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
	public ModelAndView deleteComment(@RequestParam("articleNo") int articleNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("delcomment 실행");
		commentService.deleteComment(articleNo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/club/listComment");
		return mav;
	}

	@Override
	@RequestMapping(value="/club/clubList",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listClub(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		List clubList = clubService.clubList();
		mav.addObject("clubList",clubList);
		mav.setViewName("clubHome");
		return mav;
	}

	@Override
	@RequestMapping(value="/club/modComment",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modComment(int articleNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		commentService.modComment(articleNo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}

	@Override
	@RequestMapping(value="/club/like",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView like(int articleNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		commentService.like(articleNo);
		System.out.println("vo상 like : "+commentVO.getArticleLike());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/club/listComment");
		return mav;
	}
	

}
