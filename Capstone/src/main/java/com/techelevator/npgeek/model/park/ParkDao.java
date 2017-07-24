package com.techelevator.npgeek.model.park;

import java.util.List;

public interface ParkDao {
	List<Park> getAllParks();
	Park getParkByCode(String code);
}
