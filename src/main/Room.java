/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dariel
 */
public class Room {
	
	private final String name;
	private List<String> messages = new <String>ArrayList();
	
	public Room(String name) {
		this.name = name;
	}
	
	public void addMessage(String msg) {
		messages.add(msg);
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
	public String getName() {
		return name;
	}
	
	public void flushMessages() {
		messages = new <String>ArrayList();
	}
	
}
