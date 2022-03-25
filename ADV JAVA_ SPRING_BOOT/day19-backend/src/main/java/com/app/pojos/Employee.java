package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="new_emps")
public class Employee extends BaseEntity {
	@Column(unique = true,length = 30)
	private String name;
	@Column(length = 30)
	private String location;
	@Column(length = 30)
	private String department;
}
