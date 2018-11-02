package com.qa.new_account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {
	
	public Account() {};
	
	@Id
	
	private Long ClassroomId;
	@Column(length = 100)
	
	 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_order")
	@OneToMany
	private Long trainerId;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "fk_order")
	private Long traineeId;
	private String firstName;
	@Column(length = 50)
	private String lastName;
	
	
	public Account(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
}
