package com.camilo.fedId;

import com.google.appengine.api.datastore.Entity;

public class User {
	String email;
	String username;
	Record record = new Record();
	
	void changePassword() {
		
	}
	
	int getTimesGone(String category) {
		return record.getTimesGone(category);
	}
	
	int getTimesUsed(String category) {
		return record.getTimesUsed(category);
	}
	
	void increaseTimesGone(String category) {
		record.increaseTimesGone(category);
	}
	
	void increaseTimesUsed(String category) {
		record.increaseTimeUsed(category);
	}

}
