package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDao;
	
	@RequestMapping({"/","home.do"})
	public String home(Model model) {
		model.addAttribute("Hello");
		return "home";
	}
	
	@RequestMapping(path = "searchkeyword.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> film = filmDao.findFilmByKeyword(keyword);
		mv.addObject("films", film);
		mv.setViewName("WEB-INF/result.jsp");
		return mv;
	}
	
	@RequestMapping(path = "searchid.do", params = "filmID", method = RequestMethod.GET)
	public ModelAndView getFilmByID(int filmID) {
		ModelAndView mv = new ModelAndView();
		Film film = null; 
		if (filmID <= 1000) {
			film = filmDao.findFilmByID(filmID);
		} else {
			film = filmDao.findCreatedFilmById(filmID);
		}
		mv.addObject("films", film);
		mv.setViewName("WEB-INF/result.jsp");
		return mv;
	}
	
	@RequestMapping(path = "createfilm.do", method = RequestMethod.GET)
	public ModelAndView createFilm(String keyword) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
//	
//	@RequestMapping(path = "KeywordSearch.do", params = "keyword", method = RequestMethod.GET)
//	public ModelAndView getFilmByKeyword(String keyword) {
//		ModelAndView mv = new ModelAndView();
//	
//		return mv;
//	}
//	
//	@RequestMapping(path = "KeywordSearch.do", params = "keyword", method = RequestMethod.GET)
//	public ModelAndView getFilmByKeyword(String keyword) {
//		ModelAndView mv = new ModelAndView();
//	
//		return mv;
//	}

}
