package community;

import java.util.ArrayList;
import java.util.List;

public class Communities {

	private List<Community> communities = new ArrayList<Community>();
	
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

	@Override
	public String toString() {
		return "Communities [communities=" + communities + "]";
	}
	
	
	
}
