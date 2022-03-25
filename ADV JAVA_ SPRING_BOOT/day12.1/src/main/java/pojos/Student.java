package pojos;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="students")
public class Student extends BaseEntity{
	@Column(length = 30)
	private String name;
	@Column(length = 30, unique= true)
	private String email;
	// uniDirectional Association from Student *---> Course 1
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false) // optional but recommended
	// nullable = false => Not NULL constraints
	private Course chosenCourse;

	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Student() {

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
	
	public Course getChosenCourse() {
		return chosenCourse;
	}

	public void setChosenCourse(Course chosenCourse) {
		this.chosenCourse = chosenCourse;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + "]";
	}
	
}
