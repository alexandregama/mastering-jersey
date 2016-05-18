package com.mastering.jersey.user.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	@XmlElement(name = "id")
	private Long id;

	@XmlElement(name = "name")
	private String name;

	public User() {
	}
	
	public User(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
