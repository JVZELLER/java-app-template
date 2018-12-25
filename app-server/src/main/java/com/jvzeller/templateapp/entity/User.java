package com.jvzeller.templateapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class User extends DomainEntity {
	
	private String name;
	private LocalDate birthDate;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDay(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
