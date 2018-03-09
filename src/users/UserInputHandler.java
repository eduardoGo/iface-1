package users;

import java.util.Scanner;

import enums.Handlers;

public class UserInputHandler {

	Scanner input = new Scanner(System.in);
	
	public UserInputHandler(){
		
	}
	
	public int profileEditHandler(){
		String choi = input.nextLine();
		int choice = Integer.parseInt(choi);
		while(choice < 1 || choice > 5){
			System.out.println("Invalid input, try again: ");
			choi = input.nextLine();
			choice = Integer.parseInt(choi);
		}
		return choice;
	}
	
	

}
