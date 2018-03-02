package users;

import java.util.Scanner;

import enums.Handlers;

public class UserInputHandler {

	Scanner input = new Scanner(System.in);
	
	public UserInputHandler(){
		
	}
	
	public int profileEditHandler(){
		
		int choice = input.nextInt();
		while(choice < 1 || choice > 3){
			System.out.println("Invalid input, try again: ");
			choice = input.nextInt();
		}
		
		return choice;
	}
	
	

}
