package pojos;

import javax.persistence.*;

@MappedSuperclass // to specify that class will not have any table in DB, BUT will act as a common
					// supper class for all other entities
public class BaseEntity {
	// Common data members
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
