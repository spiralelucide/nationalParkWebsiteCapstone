package com.techelevator.npgeek.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.survey.SurveyDao;
import com.techelevator.npgeek.model.survey.Survey;

@Controller
public class surveypageController {
	
	@Autowired
	private SurveyDao surveyDao;
	@Autowired
	private ParkDao parkDao;
	
	@RequestMapping(path="/surveypage", method=RequestMethod.GET)
	public String showSurvey(HttpServletRequest request, Model modelHolder){
		List<Park> parks = parkDao.getAllParks();
		request.setAttribute("parks", parks);
		if(!modelHolder.containsAttribute("surveyValidation")){
			modelHolder.addAttribute("surveyValidation", new Survey());
		}
		return "surveypage";
	}
	@RequestMapping(path="/surveypage", method=RequestMethod.POST)
	public String postSurvey(@Valid @ModelAttribute("surveyValidation") Survey surveyValidation, BindingResult result, RedirectAttributes attr){
		attr.addFlashAttribute("surveyValidation", surveyValidation);
		if(result.hasErrors()){
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "surveyValidation", result);
			return "redirect:/surveypage";
		}

		surveyDao.save(surveyValidation);
		return "redirect:/resultspage";
	}
	@RequestMapping(path="/resultspage", method=RequestMethod.GET)
	public String showResults(HttpServletRequest request){
		List<Survey> surveys = surveyDao.getSurveysForFavoritePark();
		for(Survey survey : surveys){
			survey.setParkName(parkDao.getParkByCode(survey.getParkCode()).getParkName());
		}
		request.setAttribute("surveys", surveys);
		return "resultspage";
	}
}
