package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import community.Communities;

import messages.Message;
import enums.SR;


public class UsersManager {
	
	Scanner input = new Scanner(System.in);
	private List<User> users = new ArrayList<User>();
	private Communities communities;
	

	public UsersManager() {
		users.add(new User("vaca", 123, "aurelio"));
		users.add(new User("gato", 123, "arquimedes"));
		users.add(new User("sapo", 123 , "pedro"));
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
		String raw = input.nextLine();
		password = Integer.parseInt(raw);
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
				break;
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
	
	public void sendMessage(String name){
		int currentUserId = 0;
		int iterator = 0;
		boolean found = false;
		for(User currentUser: users){
			if(currentUser.getName().equals(name)){
				currentUserId = iterator;
				break;
			}
			iterator++;
		}
		
		System.out.println("The message is to be sended to a community or a individual ?");
		System.out.println("    1. Individual");
		System.out.println("    2. Community");
		String ask = input.nextLine();
		int asw = Integer.parseInt(ask);
		while(asw < 1 || asw > 2){
			System.out.println("Invalid input, try again: ");
			ask = input.nextLine();
			asw = Integer.parseInt(ask);
		}
		
		if(asw == 2){
			// TODO communies messaging system
			
		}
		else {
			
			System.out.println("To who do you want to send the message? ");
			name = input.nextLine();
			System.out.println("Type in your message:");
			String text = input.nextLine();
			
			for(User currentUser: users){
				if(name.equals(currentUser.getName())){
					found = true;
					System.out.println("User found, message sent!");
					currentUser.getMessages().add(new Message(text, SR.RECEIVED, users.get(currentUserId).getName()));
					//System.out.println(currentUser.getMessages().get(0));
				}
			}
			if(!found) System.out.println("User not found!");
			
			users.get(currentUserId).addMessage(new Message(text, SR.SEND, name));
			
			//System.out.println(users.get(currentUserId).getMessages().get(0));	
		}
	}
	
	public User searchUser(String login) {
		for(User currentUser: users) {
			if(login.equals(currentUser.getLogin())) {
				return currentUser;
			}
		}
		return null;
	}
	
	public void deleteUser(String name) {
		
		for(User current: users){
			for(int i = 0;i < current.getFriends().size();i++){
				if(current.getFriends().get(i).equals(name)){
					current.getFriends().remove(i);
				}
			}
			for(int i = 0;i < current.getMessages().size();i++){
				if(current.getMessages().get(i).getName().equals(name)){
					current.getMessages().remove(i);
				}
			}
		}
		
		for(int i = 0; i < users.size(); i++) {
			if(name.equals(users.get(i).getName())) {
				users.remove(i);
				System.out.println("User sucessfuly removed!");
				return;
			}
		}
		System.out.println("User not found!");
	}
	
	public boolean login(String login, long password) {
		for(User currentUser: users) {
			if(login.equals(currentUser.getLogin())) {
				if(password == currentUser.getPassword()) {
					System.out.println("User loged in, welcome " + currentUser.getName());
				    return true;
				 }
			}
		}
		System.out.println("Invalid user or password");
		return false;
	}
	
	public int getUserIndex(String login) {
		for(int i = 0; i < users.size(); i++) {
			if(login.equals(users.get(i).getLogin())) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return "users=" + users + "]";
	}
}
