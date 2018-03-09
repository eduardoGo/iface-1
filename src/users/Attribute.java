package users;

import java.util.ArrayList;
import java.util.List;

public class Attribute {

	private String name;
	private List<String> value = new ArrayList<String>();
	
	public Attribute(String name){
		this.name = name;
	}
	
    public Attribute(String name, String value){
    	this.name = name;
    	this.value.add(value);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addValue(String value) {
		this.value.add(value);
	}

	@Override
	public String toString() {
		return "\nAttribute [name=" + name + ", value=" + value + "]";
	}
	
	
}
