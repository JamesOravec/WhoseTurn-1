/*
 * This class keeps a record of a user's history based on category
 * This class needs to be stored in the datastore for persistence
 */
package com.camilo.fedId;

import java.util.HashMap;
import java.util.Map;

public class Record {
	private Map<String, history> records = new HashMap<String,history>();
	
	class history {
		int timesGone = 0;
		int timesUsed = 0;
	}
	
	
	// Functions
	int getTimesGone(String category) {
		if(!records.containsKey(category))
			return -1;
		
		return records.get(category).timesGone;
	}
	
	int getTimesUsed(String category) {
		if(!records.containsKey(category))
			return -1;
		
		return records.get(category).timesUsed;
	}
	
	void increaseTimesGone(String category) {
		updateRecord(category);
		
		incrementTimesGone(records.get(category));
	}
	
	void increaseTimeUsed(String category) {
		updateRecord(category);
		
		incrementTimesUsed(records.get(category));
	}
	
	// Helper Functions
	void updateRecord(String category)
	{
		if(!records.containsKey(category))
			records.put(category, new history());
	}
	
	void incrementTimesGone(history userHistory) {
		userHistory.timesGone++;
	}
	
	void incrementTimesUsed(history userHistory) {
		userHistory.timesUsed++;
	}

}
