package com.spring.udong.member.controller;

import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.udong.member.service.MemberService;
import com.spring.udong.member.vo.MemberVO;

@EnableWebMvc
@Controller("MemberController")
public class MemberControllerImpl implements MemberController{
	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO memberVO;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		return "main";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {
		return "join";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Locale locale, Model model) {
		return "update";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}
	
	@Override
	@RequestMapping(value="/member/addMember",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addMember(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		int result = 0;
		result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/removeMember",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView removeMember(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		mav.setViewName("main");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/modMember",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("member");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String ph = request.getParameter("ph");
		memberVO.setPwd(pwd);
		memberVO.setAddress(address);
		memberVO.setEmail(email);
		memberVO.setPh(ph);
		System.out.println("id:"+memberVO.getId());
		System.out.println("email:"+memberVO.getEmail());
		System.out.println("pwd:"+memberVO.getPwd());
		System.out.println("ph:"+memberVO.getPh());
		System.out.println("address:"+memberVO.getAddress());
		memberService.updateMember(memberVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/club/clubList");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public ModelAndView login(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.loginMember(memberVO);
		if(memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);
			session.setAttribute("isLogOn", true);
			String action = (String)session.getAttribute("action");
			session.removeAttribute("action");
			if(action != null) {
				mav.setViewName("login");
			}else {
				mav.setViewName("redirect:/club/clubList");
			}
		}else {
			mav.setViewName("login");
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/member/logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}

	@Override
	@RequestMapping(value="/modInfo",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberVO",memberVO);
		mav.setViewName("update");
		return mav;
	}

}
