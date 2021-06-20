package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Message {

	private MessageType type;
	private String content;
	private String sender;

	public enum MessageType {
		CHAT, JOIN, LEAVE
	}

	public Message(String from, String msg) {
		super();
		this.from = from;
		this.msg = msg;
	}
	
	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}



}
