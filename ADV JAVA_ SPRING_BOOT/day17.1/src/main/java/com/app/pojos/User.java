package com.app.pojos;

//id | name    | email          | password | reg_amt | reg_date   | role  
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	private String name;
	@Column(unique = true) // NOT required : since unq constrint exists alrdy in db : done only for
							// understanding
	private String email;
	private String password;
	@Column(name ="reg_amt")
	private double regAmount;
	@Column(name = "reg_date")
	private LocalDate regDate;
	private String role;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" +getId()  + ", name=" + name + ", email=" + email + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + ", role=" + role + "]";
	}

}
