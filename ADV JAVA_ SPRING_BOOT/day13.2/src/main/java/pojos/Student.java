package pojos;

import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {
	@Column(length = 30)
	private String name;
	@Column(length = 30, unique = true)
	private String email;
	// uniDirectional Association from Student *---> Course 1
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false) // optional but recommended
	// nullable = false => Not NULL constraints
	private Course chosenCourse;
	// unidirectional association between ENtity and composite value type
	@Embedded // Completely optional : added only for the understanding purpose
	private AdharCard card;
	// uniDirectional association between entity --> collection of Basic value types
	// how to tell hibernate : following is a collection of BASIC value types
	@ElementCollection // mandatory
	// how to specify name of the table and Foreign Key column name?
	@CollectionTable(name = "student_hobbies", joinColumns = @JoinColumn(name = "student_id"))
	@Column(name = "hobby", length = 40, unique = true)
	private List<String> hobbies = new ArrayList<String>();
	// unidirectional association between entity and collection of composite
	// type(embeddable)
	@ElementCollection // mandatory
	@CollectionTable(name = "student_qualifications", joinColumns = @JoinColumn(name = "student_id")) // optional but
																										// recommended
																										// for
																										// specifying
																										// name of the
																										// table and
																										// Foreign key
																										// column
	private List<EducationQualification> qualification = new ArrayList<EducationQualification>();

	public Student() {

	}

	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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

	public AdharCard getCard() {
		return card;
	}

	public void setCard(AdharCard card) {
		this.card = card;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<EducationQualification> getQualification() {
		return qualification;
	}

	public void setQualification(List<EducationQualification> qualification) {
		this.qualification = qualification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
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
