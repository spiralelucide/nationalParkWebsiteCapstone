package com.techelevator.npgeek.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherDao;


@Controller

@SessionAttributes({"units","parkList"})
public class DetailpPageController {
	@Autowired
	private ParkDao parkDao;

	@Autowired
	private WeatherDao weatherDao;
	

	@RequestMapping(path="/detailpage", method=RequestMethod.GET)
	public String showParkDetails(HttpServletRequest request, ModelMap model) {
		Park park = parkDao.getParkByCode(request.getParameter("parkCode"));
		request.setAttribute("park", park);
		List<Weather> forecast= weatherDao.getForecast(request.getParameter("parkCode"));
		request.setAttribute("forecast", forecast);
		MessageGenerator message = new MessageGenerator(forecast.get(0).getForecast(),forecast.get(0).getLow(), forecast.get(0).getHigh());
		request.setAttribute("message", message.getMessage());
		request.setAttribute("units", (String)model.get("units"));
		return "detailpage";
	}
	

	@RequestMapping(path="/detailpage", method=RequestMethod.POST)
	public String showTempDetails(HttpServletRequest request, @RequestParam String code,@RequestParam String units, ModelMap model, RedirectAttributes attr) {
		model.addAttribute("units", units);
		attr.addAttribute("parkCode", code);
		
		return "redirect:/detailpage";
	}


}
