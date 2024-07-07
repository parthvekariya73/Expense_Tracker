package com.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_dtls")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    @Column(name = "full_name")
	private String fullname;

	private String email;

    private String password;
	
	public User() {
	}
	
	public User(String fullname, String email, String password) {
		this.fullname = fullname;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
