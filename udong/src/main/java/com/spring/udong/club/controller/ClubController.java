package com.spring.udong.club.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.udong.club.vo.ClubVO;
import com.spring.udong.club.vo.PageVO;

public interface ClubController {
	
	public ModelAndView listComment(PageVO pageVO,HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView addComment(HttpServletRequest request,HttpServletResponse response )throws Exception;
	
	public ModelAndView deleteComment(HttpServletRequest request,HttpServletResponse response )throws Exception;
	
	public ModelAndView modComment(@RequestParam("articleNo") int articleNo, HttpServletRequest request,HttpServletResponse response )throws Exception;
	public ModelAndView modList(@RequestParam("articleNo") int articleNo, HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView like(HttpServletRequest request,HttpServletResponse response )throws Exception;
	
	public ModelAndView addClub(@ModelAttribute("info") ClubVO clubVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView listClub(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView joinClub(HttpServletRequest request,HttpServletResponse response )throws Exception;
	
	public ModelAndView eachClubBoard(HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView addBoard(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ModelAndView checkDelId(HttpServletRequest request, HttpServletResponse response)throws DataAccessException;
}
