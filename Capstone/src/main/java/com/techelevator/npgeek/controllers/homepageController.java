package com.techelevator.npgeek.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDao;

@Controller
@SessionAttributes("parkList")
public class homepageController {
	@Autowired
	private ParkDao parkDAO;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(HttpServletRequest request, ModelMap model){
		List<Park> parkList = parkDAO.getAllParks();
		request.setAttribute("parkList", parkList);
		model.addAttribute("parkList",parkList);
		return "homepage";
	}

}
