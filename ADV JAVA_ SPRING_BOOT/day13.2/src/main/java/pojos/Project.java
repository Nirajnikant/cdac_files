package pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project extends BaseEntity {
	@Column(length = 100, unique = true)
	private String title;
	@Column(length = 100)
	private String technology;
	@Column(name = "comletion_date")
	private LocalDate completionDate;
	// Many to Many unidirectional association Project *----> * Student (between 2
	// entities)
	@ManyToMany // mandatory, otherwise :: MappingException
	@JoinTable(name = "projects_students", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<Student> students = new HashSet<Student>();
	
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(String title, String technology, LocalDate completionDate) {
		super();
		this.title = title;
		this.technology = technology;
		this.completionDate = completionDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	// 2 methods : add student and remove student
	public void addStudent(Student s) {
		students.add(s);
	}
	
	public void removeStudent(Student s) {
		students.remove(s);
	}
	
	@Override
	public String toString() {
		return "Project ID " + getId() + "[title=" + title + ", technology=" + technology + ", completionDate="
				+ completionDate + "]";
	}

}
