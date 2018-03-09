package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import messages.Message;

import community.Community;

public class User {
	
	private String login;
	private long password;
	private String name;
	
	private List<String> friends = new ArrayList<String>();
	private UserInputHandler handler = new UserInputHandler();
	private relationshipsManager inviteManager = new relationshipsManager();
	private List<Community> communities = new ArrayList<Community>();
	private List<Message> messages = new ArrayList<Message>();
	private List<Attribute> attributes =  new ArrayList<Attribute>();
	
	Scanner input = new Scanner(System.in);

	public User() {
		
	}
	
	public User(String login, long password, String name){
		this.login = login;
		this.password = password;
		this.name = name;
	}
	
	public void editUserProfile(){
		int choice;
		System.out.println("Choose what you want to edit in the user's profile: ");
		System.out.println("    1. login");
		System.out.println("    2. password");
		System.out.println("    3. name");
		System.out.println("    4. create a new attribute to your profile");
		System.out.println("    5. add a value to a existing custom attribute");
		
		choice = this.handler.profileEditHandler();
		
		switch (choice){
		    case 1:
		    	System.out.println("Type in the new user's login: ");
		    	String login = input.nextLine();
		    	this.login = login;
		    	break;
		    case 2:
		    	System.out.println("Type in the new user's password: ");
		    	long password = input.nextLong();
		    	this.password = password;
		    	break;
		    case 3:
		    	System.out.println("Type in the new user's name: ");
		    	String name = input.nextLine();
		    	this.name = name;
		    	break;
		    case 4:
		    	System.out.println("Type in the new attribute name: ");
		    	String inputt = input.nextLine();
		    	this.attributes.add(new Attribute(inputt));
		    	break;
		    case 5:
		    	System.out.println("Type in the attribute that you want to add a value name: ");
		    	String att = input.nextLine();
		    	
		    	for(Attribute current: attributes){
		    		if(current.getName().equals(att)){
		    			System.out.println("Attribute found type in a value to be added to it: ");
		    			String value = input.nextLine();
		    			current.addValue(value);
		    		}
		    	}
		    	break;
		    default:
		    	break;
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public long getPassword() {
		return password;
	}

	public void setPassword(long password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public relationshipsManager getInviteManager() {
		return inviteManager;
	}

	public void setInviteManager(relationshipsManager inviteManager) {
		this.inviteManager = inviteManager;
	}

	public boolean searchForInvite(String name) {
		if(this.inviteManager.search(name)){
			return true;
		}
		return false;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	public Community addCommunity(){
		Community community = new Community();
		community.createCommunity(this.name);
		community.addMember(this.name);
		this.communities.add(community);
		
		return community;
	}
	
	public void addCommunity(Community comm){
		this.communities.add(comm);
	}
	
	public void showCommunities() {
		int i = 0;
		for(Community current: communities) {
			System.out.println(i + ". " + current);
			i++;
		}
	}

	public List<Community> getCommunities() {
		return communities;
	}

	public void setCommunities(List<Community> communities) {
		this.communities = communities;
	}
	
	public void addMessage(Message message){
		this.messages.add(message);
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "\nUser [login=" + login + ", password=" + password + ", name="
				+ name + ", friends=" + friends
				+ ", communities="
				+ communities + ", messages=" + messages
				+ ", attributes=" + attributes
				+ "]";
	}
}
