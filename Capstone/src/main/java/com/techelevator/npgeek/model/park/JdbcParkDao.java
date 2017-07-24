package com.techelevator.npgeek.model.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.DollarAmount;

@Component
public class JdbcParkDao implements ParkDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks(){
		List<Park> parks = new ArrayList<>();
		String sqlSelect = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelect);
		while(results.next()){
			Park park = mapRowToPark(results);
			parks.add(park);
		}
		return parks;
	}
	private Park mapRowToPark(SqlRowSet results){
		Park park = new Park();
		park.setParkCode(results.getString("parkCode"));
		park.setParkName(results.getString("parkName"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevationInFeet(results.getInt("elevationInFeet"));
		park.setMilesOfTrail(results.getDouble("milesOfTrail"));
		park.setNumberOfCampsites(results.getInt("numberOfCampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearFounded"));
		park.setAnnualVisitorCount(results.getInt("annualVisitorCount"));
		park.setInspirationalQuote(results.getString("inspirationalQuote"));
		park.setQuoteSource(results.getString("inspirationalQuoteSource"));
		park.setParkDescription(results.getString("parkDescription"));
		park.setNumberOfAnimalSpecies(results.getInt("numberOfAnimalSpecies"));
		
		int dollars = results.getInt("entryFee");
		DollarAmount fee = new DollarAmount(dollars*100);
		park.setEntryFee(fee);
		
		return park;
	}

	@Override
	public Park getParkByCode(String code) {
		String sqlSelect = "SELECT * FROM park WHERE parkCode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelect, code);
		Park park = new Park();
		if(result.next()){
			park = mapRowToPark(result);			
		}else{
			throw new RuntimeException("Weird, query came back with unexpected results");
		}
		return park;
	}
}
