package tests;
import users.User;
import users.UsersManager;

import java.util.ArrayList;
import java.util.List;

import community.Communities;
import community.Community;

public class tests {
	
	public tests() {
		
	}


	public static void main(String[] args) {
		
		List<User> users = new ArrayList<User>();
		UsersManager manager = new UsersManager();
		Communities comm = new Communities();
		
		users.add(new User("arqui456", 123, "arquimedes"));
		users.add(new User("btracker", 312, "wykthor"));
		users.add(new User("vaca123", 111, "aurelio"));
		
		System.out.println(users);
		manager.setUsers(users);
		
		manager.addFriend("arqui456");
		manager.addFriend("arqui456");
		manager.addFriend("wykthor");
		
		System.out.println(users);
		
		comm.add(users.get(0).addCommunity());
		
		System.out.println(comm);

	}

}
