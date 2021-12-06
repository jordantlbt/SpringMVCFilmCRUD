package com.skilldistillery.film.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDao;
	
	@RequestMapping({"/","home.do"})
	public String home() {
		return "home";
	}
	@RequestMapping({"createFilm.do"})
	public String createFilm() {
		return "createFilm";
	}
	@RequestMapping({"updatefilm.do"})
	public String updateFilm(Model model, int filmID) {
		Film film = filmDao.findFilmByID(filmID);
		model.addAttribute("film", film);
		
		return "updatefilm";
	}
//	searches filmDB by keyword 
	@RequestMapping(path = "searchkeyword.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDao.findFilmByKeyword(keyword);
		mv.addObject("films", films);
		mv.setViewName("filmByKeyword");
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
		mv.addObject("film", film);
		mv.setViewName("result");
		return mv;
	}
//	prompts to create film
	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
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
//	@RequestMapping(path = "updatedfilm.do", method = RequestMethod.GET)
//	public ModelAndView updateFilm(@ModelAttribute("film") Film film) {
//		ModelAndView mv = new ModelAndView();
//		
//		filmDao.updateFilm(film);
//		mv.addObject("updatedfilm", film);
//		mv.setViewName("result");
//		return mv;
//	}
	
	
	  @RequestMapping(path = "updatefilm.do", method = RequestMethod.POST)
	  public ModelAndView editFilm(Film film) {
		  ModelAndView mv = new ModelAndView();  
		  Film f = filmDao.updateFilm(film);
		  filmDao.updateFilm(f);
		  mv.addObject("film", f);
		  mv.setViewName("result");
		  return mv;
	  }	
	
////	view film properties
//	@RequestMapping(path = "viewfilmprops.do", method = RequestMethod.POST)
//	public ModelAndView viewfilmprops(@ModelAttribute("film") Film film) {
//		ModelAndView mv = new ModelAndView();
//		int searchFilmID = film.getfilmID();
//		if (searchFilmID <= 1000) {
//			film = filmDao.findFilmByID(searchFilmID);
//		} else {
//			film = filmDao.findCreatedFilmById(searchFilmID);
//		}
//		filmDao.updateFilm(film); 
//		mv.setViewName("result"); //change redirected page 
//		return mv;
//	}
	
	@RequestMapping(path = "deletefilm.do",  method = RequestMethod.GET)
	public ModelAndView deletefilm(int filmID) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDao.findFilmByID(filmID);
		System.err.println(film);
		if(film != null) {
			filmDao.deleteFilm(film);
			mv.setViewName("deleteFilm"); //change redirected page
			return mv;
		}
		film = filmDao.findCreatedFilmById(filmID);
		if (film != null) {
			filmDao.deleteFilm(film);
			mv.setViewName("deleteFilm"); //change redirected page
			return mv;
		}
		mv.setViewName("unsuccessful");
		return mv;
	}
}

