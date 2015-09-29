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
public class User {
	
	private final String name;
	private final List<Room> channels = new <Room>ArrayList();
	
	public User(String name) {
		this.name = name;
		join("lounge");
	}
	
	public void Broadcast(String room, String message) {
		for (Room channel : channels) {
			if (channel.getName().equals(room)) {
				channel.addMessage(message);
			}
		}
	}
	
	public List<String> getMessages() {
		List<String> messages = new <String>ArrayList();
		for (Room channel : channels) {
			messages.addAll(channel.getMessages());
			channel.flushMessages();
		}
		return messages;
	}
	
	public void join(String room) {
		channels.add(new Room(room));
		Broadcast(room, "[" + room + "] - " + name + " has joined the room");
	}
	
	public int leave(String room) {
		int retval = 1;
		for (Room channel : channels) {
			if (channel.getName().equals(room)) {
				channels.remove(channel);
				retval = 0;
			}
		}
		return retval;
	}
	
	public String getName() {
		return name;
	}
	
}
