package community;

import java.util.ArrayList;
import java.util.List;

import messages.Message;

public class Communities {

	private List<Community> communities = new ArrayList<Community>();
	private List<Message> chatbox = new ArrayList<Message>();
	
	public Communities() {
		
	}

	public List<Community> getCommunities() {
		return communities;
	}

	public void setCommunities(List<Community> communities) {
		this.communities = communities;
	}
	
	public void add(Community community){
		this.communities.add(community);
	}
	
	public void showCommunities(){
		for(Community current: communities) {
		   System.out.println(current);	
		}
	}

	@Override
	public String toString() {
		return "Communities [communities=" + communities + "]";
	}
	
	
	
}
