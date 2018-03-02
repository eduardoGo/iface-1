package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersManager {
	
	Scanner input = new Scanner(System.in);
	private List<User> users = new ArrayList<User>();

	public UsersManager() {
		
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(){
		
	   	String login;
		long password;
		String name;
		
		System.out.println("Type in the user's login: ");
		login = input.nextLine();
		System.out.println("Type in the user's password: ");
		password = input.nextLong();
		System.out.println("Type in the users's name: ");
		name = input.nextLine();
		
		User user = new User(login, password, name);
		
		users.add(user);
	}
	
	public void addFriend(String name){
		int currentUserId = 0;
		int iterator = 0;
		boolean found = false;
		for(User currentUser: users){
			if(currentUser.getName().equals(name)){
				currentUserId = iterator;
			}
			iterator++;
		}
		System.out.println("Who do you want to add? ");
		name = input.nextLine();
		found = false;
		for(User currentUser : users){
			if(name.equals(currentUser.getName())){
				found = true;
				System.out.println("User name found, invite sent");
				currentUser.getInviteManager().addInvite(users.get(currentUserId).getName());
				
				if(users.get(currentUserId).searchForInvite(currentUser.getName())){
					System.out.println("Invite by this person found, adding as friends");
					currentUser.getFriends().add(users.get(currentUserId).getName());
					users.get(currentUserId).getFriends().add(currentUser.getName());
				}
				break;
			}
		}
		if(!found){
			System.out.println("User don't exits within the database!");
		}
	}
	
	

}
