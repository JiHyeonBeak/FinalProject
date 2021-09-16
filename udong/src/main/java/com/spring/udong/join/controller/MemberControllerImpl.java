package com.spring.udong.join.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.udong.join.service.MemberService;
import com.spring.udong.join.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController{
	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO membervo;
	
	@RequestMapping(value={"/","/join.do"},method=RequestMethod.POST)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	public ModelAndView listMembers(HttpServletResponse respnse, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView addMember(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView removeMember(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
