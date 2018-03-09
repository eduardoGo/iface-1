package community;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Community {

	private String name;
	private String description;
	private String admin;
	private List<String> members = new ArrayList<String>();
	
	Scanner input = new Scanner(System.in);
	
	public Community() {

	}
	
	public Community(String name, String description, String admin){
		this.name = name;
		this.description = description;
		this.admin = admin;
	}
	
	public void createCommunity(String admin){
		System.out.println("What will be the name of this new community ?");
		String name = input.nextLine();
		System.out.println("Type in a small description of this community: ");
		String description = input.nextLine();
		
		this.admin = admin;
		this.description = description;
		this.name = name;
	}
	
	public void addMember(String newMember){
		this.members.add(newMember);
	}

	@Override
	public String toString() {
		return "\nCommunity [name=" + name + ", description=" + description
				+ ", admin=" + admin + ", members=" + members + "]";
	}
	
}
