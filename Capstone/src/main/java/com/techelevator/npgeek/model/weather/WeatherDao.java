package com.techelevator.npgeek.model.weather;

import java.util.List;

public interface WeatherDao {
	List<Weather> getForecast(String parkCode);
}
