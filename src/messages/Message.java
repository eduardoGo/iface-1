package messages;

import enums.SR;

public class Message {

	private String text;
	private SR sendOrReceived;
	private String name;
	
	public Message(){
		
	}
	
	public Message(String text, SR sendOrReceived, String name){
		this.text = text;
		this.sendOrReceived = sendOrReceived;
		this.name = name;
	}
	
	public SR getSendOrReceived() {
		return sendOrReceived;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "\nMessage [text=" + text + ", sendOrReceived=" + sendOrReceived
				+ ", name=" + name + "]";
	}

}
