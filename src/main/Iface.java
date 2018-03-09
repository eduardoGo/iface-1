package main;

import users.UsersManager;

public class Iface {
	 
	
	public static void main(String[] args) {
		
		UsersManager manager = new UsersManager();
		Interface gui = new Interface();
		gui.renderInterface(manager);
	}
}
