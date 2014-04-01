package edu.ycp.cs496.ghosts.controller;

import edu.ycp.cs496.ghosts.model.User;
import edu.ycp.cs496.ghosts.model.persist.DatabaseProvider;
import edu.ycp.cs496.ghosts.model.persist.IDatabase;

public class GetUserController {
	public User getUser(String userName, String password){
		IDatabase db = DatabaseProvider.getInstance();
		return db.getUser(userName, password);
	}
}
