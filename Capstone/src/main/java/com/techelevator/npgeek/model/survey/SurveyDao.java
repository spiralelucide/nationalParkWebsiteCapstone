package com.techelevator.npgeek.model.survey;

import java.util.List;

public interface SurveyDao {
	
//	List<Survey> getAllSurveys();
	void save(Survey survey);
	List<Survey> getSurveysForFavoritePark();
}
