package pojos;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
	@Column(length = 30, unique = true)
	private String title;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	private double fees;
	private int capacity;
	// Association mapping : uniDirectional Associaion from course 1 ---->* Student
	@OneToMany(mappedBy = "chosenCourse", cascade = CascadeType.ALL, orphanRemoval = true/*, fetch = FetchType.EAGER*/)
	private List<Student> students = new ArrayList<Student>();// ALWAYS init the collections to avoid NPE

	public Course() {

	}

	public Course(String title, LocalDate startDate, LocalDate endDate, double fees, int capacity) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// add helper methods to establish a bidirectinal Course and Student
	public void addStudent(Student s) {
		students.add(s);// course --> student
		s.setChosenCourse(this); // student --> course
	}

	// add helper methods to establish a bidirectinal Course and Student
	public void removeStudent(Student s) {
		students.remove(s); // course ---X---> student
		s.setChosenCourse(null); // student ---X---> course
	}
	@Override
	public String toString() {
		return "Course [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", fees=" + fees
				+ ", capacity=" + capacity + "]";
	}

}