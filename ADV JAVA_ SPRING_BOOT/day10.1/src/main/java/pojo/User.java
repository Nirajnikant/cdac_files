package pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

// Is it mandatory to make POJO class impliment Serializable? NO
// BUT unique ID property --> PK --> MUST be Serializable

@Entity // mandatory class level annotation
@Table(name = "users_tbl")
public class User {
	@Id // mandatory field level (alternatively can be added on the getter : property
		// level) ==> PK constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generating id' using constraint : auto_increment
	@Column(name = "user_id")
	private Integer userId;
	@Column(length = 30) // varchar(30)
	private String name;
	@Column(length = 30, unique = true) // adds unique constraint
	private String email;
	@Column(length = 30, nullable = false) // varchar(30), NOT NULL constraint
	private String password;
	@Transient // skips from persistence :: NO column is created for this
	private String confirmPassword;
	@Enumerated(EnumType.STRING) //=> column : varchar
	@Column(length = 20, name="user_role")
	private Role userRole;
	@Column(name = "reg_amount")
	private double regAmount;
	@Column(name="reg_date")
	private LocalDate regDate;
	@Lob // large object : default type : medium blob
	private byte[] image;

	public User(String name, String email, String password, String confirmPassword, Role userRole, double regAmount,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userRole = userRole;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	
	// adding overloaded constructor to test "constructor expression in JPQL"
	public User(String name, String email, double regAmount, LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	
	
	// POJO spec
	public User() {
		System.out.println("In constructor of " + getClass());
	}

	// generates all settes and getters
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	// toString : optional
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", userRole=" + userRole + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + ", image=" + Arrays.toString(image) + "]";
	}

}