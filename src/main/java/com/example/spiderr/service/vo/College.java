

package com.example.spiderr.service.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int noOfstudent;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfstudent() {
		return noOfstudent;
	}
	public void setNoOfstudent(int noOfstudent) {
		this.noOfstudent = noOfstudent;
	}
	public College(String name, int noOfstudent) {
		super();
		this.name = name;
		this.noOfstudent = noOfstudent;
	}
	
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

}
