package com.techelevator.npgeek.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

//	@Override
//	public List<Survey> getAllSurveys() {
//		List<Survey> surveys = new ArrayList<>();
//		String sqlSelect = "SELECT * FROM survey_result";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelect);
//		while(results.next()){
//			Survey survey = mapResultsToSurvey(results);
//			surveys.add(survey);
//		}
//		return surveys;
//	}
//	private Survey mapResultsToSurvey(SqlRowSet results){
//		Survey survey = new Survey();
//		survey.setSurveyId(results.getInt("surveyId"));
//		survey.setParkCode(results.getString("parkCode"));
//		survey.setEmailAddress(results.getString("emailAddress"));
//		survey.setState(results.getString("state"));
//		survey.setActivityLevel(results.getString("activityLevel"));
//		
//		return survey;
//	}

	@Override
	public void save(Survey survey) {
		int id = getNextId();
		String sqlInsert = "INSERT INTO survey_result(surveyId, parkCode, emailAddress, state, activityLevel) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sqlInsert,id,survey.getParkCode(),survey.getEmailAddress(),survey.getState(),survey.getActivityLevel());
		survey.setSurveyId(id);
	}
	private int getNextId(){
		String sqlSelect = "SELECT NEXTVAL('seq_surveyId')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelect);
		int id = -1;
		if(results.next()){
			id = results.getInt(1);
		}else{
			throw new RuntimeException("Weird, such empty");
		}
		return id;
	}

	@Override
	public List<Survey> getSurveysForFavoritePark() {
		List<Survey> favorites = new ArrayList<>();
		String sqlStatement = "SELECT count(parkCode), parkCode FROM survey_result GROUP BY parkCode ORDER BY count desc, parkCode asc;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement);
		while(results.next()){
			Survey survey = new Survey();
			survey.setVotes(results.getInt("count"));
			survey.setParkCode(results.getString("parkCode"));
			favorites.add(survey);
		}
		return favorites;
	}
}
