package com.camilo.fedId;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class User {
	// Create user entity and add it to the datastore for persistence
	public static void createUser(String name, Record record) {
		Entity user = getUser(name);
		if(user == null) {
			user = new Entity("User", name);
			user.setProperty("record", record);
		}
		Util.persistEntity(user);
	}
	
	public static Entity getUser(String name) {
		Key key = KeyFactory.createKey("User", name);
		return Util.findEntity(key);
	}
	
	void changePassword() {
		
	}
	
	public int getTimesGone(String userName, String category) {
		Record record = getRecord(userName);
		return record.getTimesGone(category);
	}
	
	public int getTimesUsed(String userName, String category) {
		Record record = getRecord(userName);
		return record.getTimesUsed(category);
	}
	
	public void increaseTimesGone(String userName, String category) {
		Record record = getRecord(userName);
		record.increaseTimesGone(category);
	}
	
	public void increaseTimesUsed(String userName, String category) {
		Record record = getRecord(userName);
		record.increaseTimesUsed(category);
	}
	
	// Helper Functions
	Record getRecord(String userName) {
		Entity entity = getUser(userName);
		return (Record) entity.getProperty("record");
	}
}
