package com.spring.udong.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.udong.member.service.MemberService;
import com.spring.udong.member.vo.MemberVO;

@Controller
public class MemberControllerImpl implements MemberController{
	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO memberVO;
	
	
	@Override
	@RequestMapping(value="addMember",method=RequestMethod.GET)
	public ModelAndView addMember(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@Override
	@RequestMapping(value="/member/removeMember",method=RequestMethod.GET)
	public ModelAndView removeMember(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView();
		return mav;
	}

}
