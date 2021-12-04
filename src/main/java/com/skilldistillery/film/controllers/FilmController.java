package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
//	searches filmDB by keyword 
	@RequestMapping(path = "searchkeyword.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> film = filmDao.findFilmByKeyword(keyword);
		mv.addObject("films", film);
		mv.setViewName("result");
		return mv;
	}
//	searches filmDB by id 
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
		mv.setViewName("result");
		return mv;
	}
//	prompts to create film
	@RequestMapping(path = "createfilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(@ModelAttribute("film") Film film) {
		ModelAndView mv = new ModelAndView();
		Film createdFilm = filmDao.createFilm(film);
		if (createdFilm != null) {
			mv.addObject("createdFilm", createdFilm);
			mv.setViewName("result"); 
		}
		return mv;
	}
//	prompts to update film
	@RequestMapping(path = "updatefilm.do", method = RequestMethod.GET)
	public ModelAndView updateFilm(@ModelAttribute("film") Film film) {
		ModelAndView mv = new ModelAndView();
		filmDao.updateFilm(film);
		mv.setViewName("result");
		return mv;
	}
	
//	search for updated film 
	@RequestMapping(path = "updatefilm.do", method = RequestMethod.POST)
	public ModelAndView getUpdateDFilm(@ModelAttribute("film") Film film) {
		ModelAndView mv = new ModelAndView();
		int searchFilmID = film.getfilmID();
		if (searchFilmID <= 1000) {
			film = filmDao.findFilmByID(searchFilmID);
		} else {
			film = filmDao.findCreatedFilmById(searchFilmID);
		}
		filmDao.updateFilm(film); 
		mv.setViewName("result");
		return mv;
	}
	
//	@RequestMapping(path = "KeywordSearch.do", params = "keyword", method = RequestMethod.GET)
//	public ModelAndView getFilmByKeyword(String keyword) {
//		ModelAndView mv = new ModelAndView();
//	
//		return mv;
//	}

}
