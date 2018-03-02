package users;

import java.util.ArrayList;
import java.util.List;

public class relationshipsManager {
	
	private List<String> invites = new ArrayList<String>(); 

	public relationshipsManager() {

	}
	
	public void addInvite(String name){
		if(!search(name))
		    this.invites.add(name);
		else
			System.out.println("You already send a invite to this person!");
	}

	public boolean search(String name){
		for (String currentInvite: invites){
			if(currentInvite.equals(name)){
				return true;
			}
		}
		return false;
	}
}
