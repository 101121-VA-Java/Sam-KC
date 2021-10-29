package com.revature.repositories;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.User;

public class UserDaoList implements UserDao {
	
	public List<User> Users;


	@Override
	public boolean addUser(User u) {

		u.setId(Users.size());
		Users.add(u);
		return true;
	}

	@Override
	public boolean loginUser(User u) {
		if (Users.contains(u)) {
			return true;
		}
		return false;
	}

}
