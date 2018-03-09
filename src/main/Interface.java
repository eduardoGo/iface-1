package main;

import java.util.Scanner;
import users.User;
import users.UsersManager;

public class Interface {
	
	Scanner inputer = new Scanner(System.in);
	
	public Interface() {
		
	}
	
	public void renderInterface(UsersManager manager){
		
		int input = 0;
		boolean on = true;
		boolean logged = false;
		
		while(on) {
			
			System.out.println("Welcome to Iface.com");
			System.out.println("    1. Log in");
			System.out.println("    2. Create a account");
			System.out.println("    3. Exit");
			System.out.println("    4. DEBUG");
			
			String choice = inputer.nextLine();
			input = Integer.parseInt(choice);
			while(input < 1 || input > 4) {
				System.out.println("Invalid input, try again: ");
				choice = inputer.nextLine();
				input = Integer.parseInt(choice);
			}
			
			long password = 0;
			String login;
			switch(input) {
			    case 1:
			    	System.out.println("Type in your user login: ");
			    	login = inputer.nextLine();
			    	System.out.println("Type in your user password: ");
			    	choice = inputer.nextLine();
			    	password = Integer.parseInt(choice);
			    	logged = manager.login(login, password);
			    	while(logged)
			    	    logged = loggedInScreen(manager.searchUser(login), manager);
			    	break;
			    case 2:
			    	manager.addUser();
			    	break;
			    case 3:
			    	on = false;
			    	break;
			    case 4:
			    	System.out.println(manager);
			}
		}
	}
	
	public boolean loggedInScreen(User user, UsersManager manager) {
		
		System.out.println("What do you want to do? ");
		System.out.println("    1. Add/edit my profile");
		System.out.println("    2. Add/invite a friend");
		System.out.println("    3. Send a message");
		System.out.println("    4. Create a community");
		System.out.println("    5. Add a member to a community");
		System.out.println("    6. Retrieve my info");
		System.out.println("    7. Delete my account");
		System.out.println("    8. Log out");
		
		String choice = inputer.nextLine();
		int input = Integer.parseInt(choice);
		while(input < 1 || input > 8) {
			System.out.println("invalid input, try again: ");
			choice = inputer.nextLine();
			input = Integer.parseInt(choice);
		}
		
		int userIndex = manager.getUserIndex(user.getLogin());
		
		switch (input) {
	    case 1:
	    	System.out.println("Adding/editing user profile...");
	    	manager.getUsers().get(userIndex).editUserProfile();
	    	break;
	    case 2:
	    	System.out.println("adding friend...");
	    	manager.addFriend(user.getName());
	    	break;
	    case 3:
	    	System.out.println("sending message...");
	    	manager.sendMessage(user.getName());
	    	break;
	    case 4:
	    	System.out.println("creating community...");
	    	manager.getUsers().get(userIndex).addCommunity();
	    	break;
	    case 5:
	    	int aux = 0;
	    	System.out.println("The new member will be added in which community? ");
	    	manager.getUsers().get(userIndex).showCommunities();
	    	aux = manager.getUsers().get(userIndex).getCommunities().size();
	    	choice = inputer.nextLine();
	    	input = Integer.parseInt(choice);
	    	while(input < 0 || input > aux - 1) {
	    		System.out.println("Invalid input, try again: ");
	    		choice = inputer.nextLine();
		    	input = Integer.parseInt(choice);
	    	}
	    	System.out.println("Type in the new member name: ");
	    	String newMember = inputer.nextLine();
	    	manager.getUsers().get(userIndex).getCommunities().get(input).addMember(newMember);
	    	System.out.println("adding member...");
	    	break;
	    case 6:
	    	System.out.println("Retrieving user's information...");
	    	System.out.println(user);
	    	break;
	    case 7:
	    	System.out.println("Removing user's account...");
	    	manager.deleteUser(user.getName());
	    	return false;
	    case 8:
	    	System.out.println("Logging out...");
	    	return false;
	    default:
	    	System.out.println("Invalid input");
	    	break;
	    }
		return true;
	}
}
