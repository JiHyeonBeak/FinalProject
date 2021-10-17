package com.spring.udong.club.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.udong.club.service.BoardService;
import com.spring.udong.club.service.ClubService;
import com.spring.udong.club.service.CommentService;
import com.spring.udong.club.vo.ClubVO;
import com.spring.udong.club.vo.CommentVO;
import com.spring.udong.club.vo.JoinVO;
import com.spring.udong.member.vo.MemberVO;

@Controller("clubController")
public class ClubControllerImpl implements ClubController{
	@Autowired
	private CommentService commentService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private ClubService clubService;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private JoinVO joinVO;
	@Autowired
	private CommentVO commentVO;
	
	@RequestMapping(value="/club/home", method=RequestMethod.GET)
	public String clubHome(Locale locale, Model model) {
		return"clubHome";
	}
	
	@RequestMapping(value="/club/main", method = {RequestMethod.GET, RequestMethod.POST})
		public String main(HttpServletRequest request, HttpServletResponse response) {
			return"clubMain";
		}
	
	@RequestMapping(value="club/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String addClub(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("member");
		mav.addObject("member",memberVO);
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
			HttpSession session = request.getSession();
			memberVO = (MemberVO)session.getAttribute("member");
			String category = request.getParameter("group_category");
			String id = memberVO.getId();
			clubVO.setGroup_category(category);
			clubVO.setGroup_leader(id);
			int result = 0;
			result = clubService.addClub(clubVO);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/club/clubList");
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
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("member");
		List joinList = clubService.joinList(memberVO);
		List clubList = clubService.clubList();
		mav.addObject("clubList",clubList);
		mav.addObject("joinList",joinList);
		mav.setViewName("clubHome");
		return mav;
	}

	@Override
	@RequestMapping(value="/club/modComment",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modComment(int articleNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("모드컨트롤러 상 no : "+articleNo);
		commentService.modComment(articleNo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/club/listComment");
		return mav;
	}

	@Override
	@RequestMapping(value="/club/like",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView like(int articleNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		int like = commentService.like(articleNo);
		System.out.println("vo상 like : "+commentVO.getArticleLike());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/club/listComment");
		return mav;
	}

	@Override
	@RequestMapping(value="/club/dislike",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView dislike(int articleNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		commentService.dislike(articleNo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/club/listComment");
		return mav;
	}

	@Override
	@RequestMapping(value= "/club/modList", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modList(int articleNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		List modList = commentService.modList(articleNo);
		mav.addObject("modComment", modList);
		mav.setViewName("clubMain");
		return mav;
	}

	@Override
	@RequestMapping(value="/club/joinClub", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView joinClub(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("member");
		int groupid = Integer.parseInt(request.getParameter("group_id"));
		joinVO.setGroup_id(groupid);
		joinVO.setId(memberVO.getId());
		clubService.joinClub(joinVO);
		mav.setViewName("redirect:/club/clubList");
		return mav;

	}

	@Override
	@RequestMapping(value="/club/eachClubBoard", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView eachClubBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		int groupId = Integer.parseInt(request.getParameter("group_id"));
		joinVO.setGroup_id(groupId);
		List boardList = boardService.listBoard(joinVO);
		mav.addObject("boardList",boardList);
		mav.setViewName("eachClub");
		return mav;
	}


}
