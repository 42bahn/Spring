package com.basicmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.basicmvc.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public ModelAndView list(Locale locale, @RequestParam Map<String, Object> map) {
		logger.info("Welcome Board! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		List<Map<String, Object>> list = this.boardService.list(map);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data", list);
		mav.addObject("serverTime", formattedDate);
		mav.setViewName("/board/list");
		return mav;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map){
		Map<String, Object> detailMap = this.boardService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		String boardId = map.get("boardId").toString();
		mav.addObject("boardId", boardId);
		mav.setViewName("/board/detail");
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		return new ModelAndView("board/create");
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		String boardId = this.boardService.create(map);
		if (boardId == null) {
			mav.setViewName("redirect:/create");
		}
		else {
			mav.setViewName("redirect:/detail?boardId=" + boardId);
		}
		return mav;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView modify(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.boardService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		mav.setViewName("/board/modify");
		return mav;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modifyPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		if (this.boardService.modify(map) == true) {
			mav.setViewName("redirect:/detail?boardId=" + map.get("boardId"));
		}
		else {
			mav = this.modify(map);
		}
		return mav;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public ModelAndView removePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		if (this.boardService.remove(map) == true) {
			mav.setViewName("redirect:/list");
		}
		else {
			mav.setViewName("redirect:/detail?boardId=" + map.get("boardId"));
		}
		return mav;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchPost(@RequestParam Map<String, Object> map, Locale locale) {
		ModelAndView mav = new ModelAndView();
		
		try {
			this.boardService.search(map);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			mav = this.list(locale, map);
		}
		return mav;
	}
}
