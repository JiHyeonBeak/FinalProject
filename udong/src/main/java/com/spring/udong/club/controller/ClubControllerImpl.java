package com.spring.udong.club.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.udong.club.service.BoardService;
import com.spring.udong.club.service.ClubService;
import com.spring.udong.club.service.CommentService;
import com.spring.udong.club.vo.BoardVO;
import com.spring.udong.club.vo.ClubVO;
import com.spring.udong.club.vo.CommentVO;
import com.spring.udong.club.vo.JoinVO;
import com.spring.udong.club.vo.PageVO;
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
	@Autowired
	private BoardVO boardVO;
	@Autowired
	private PageVO pageVO;
	
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
	public ModelAndView listComment(PageVO pageVO,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nowPage = request.getParameter("nowPage");
		String perPage = request.getParameter("perPage");
		
		ModelAndView mav = new ModelAndView();
		int total = commentService.countComment();
		if(nowPage == null && perPage == null) {
			nowPage = "1";
			perPage = "5";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(perPage == null) {
			perPage = "5";
		}
		pageVO.setTotal(total);
		pageVO.setNowPage(Integer.parseInt(nowPage));
		pageVO.setPerPage(Integer.parseInt(perPage));
		System.out.println("토탈페이지 : "+pageVO.getTotal());
		System.out.println("라스트페이지 : "+pageVO.getLastPage());
		System.out.println("스타트 페이지 : "+pageVO.getStartPage());
		System.out.println("엔드페이지 : "+pageVO.getEndPage());
		System.out.println("펄페이지 : "+pageVO.getPerPage());
		System.out.println("나우페이지 : "+pageVO.getNowPage());
		System.out.println("엔드 : "+pageVO.getEnd());
		System.out.println("시작페이지 : "+pageVO.getStart());
		List commentList = commentService.listComment(pageVO);
		mav.addObject("page",pageVO);
		mav.addObject("viewAll",commentList);
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
	@ResponseBody
	@RequestMapping(value="/club/delComment",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteComment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("member");
		String seId = memberVO.getId();
		String id = request.getParameter("articleId");
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		if(seId.equals(id)) {
			commentService.deleteComment(articleNo);
		}else if(!seId.equals(id)){
		}
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
		commentService.modComment(articleNo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/club/listComment");
		return mav;
	}

	@Override
	@RequestMapping(value="/club/like",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView like(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		commentService.like(articleNo);
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
		int groupid = Integer.parseInt(request.getParameter("groupId"));
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
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		String groupName = request.getParameter("groupName");
		joinVO.setGroup_id(groupId);
		List boardList = boardService.listBoard(joinVO);
		mav.addObject("groupName",groupName);
		mav.addObject("groupId",groupId);
		mav.addObject("boardList",boardList);
		mav.setViewName("eachClub");
		return mav;
	}

	@Override
	@RequestMapping(value="/club/addBoard", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		mav.addObject("groupId",groupId);
		boardVO.setGroupId(groupId);
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("member");
		boardVO.setArticleId(memberVO.getId());
		boardVO.setArticleTitle(request.getParameter("articleTitle"));
		boardVO.setArticleContent(request.getParameter("articleContent"));
		int result = boardService.addBoard(boardVO);
		mav.setViewName("redirect:/club/eachClubBoard");
		return mav;
	}

	@Override
	public ModelAndView checkDelId(HttpServletRequest request, HttpServletResponse response) throws DataAccessException {
		ModelAndView mav = new ModelAndView();
		
		
		return null;
	}


}
