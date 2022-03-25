package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// how to tell hibernate the following class has no separate existence and it's contents are going to be embedded in the owning entity
// Association between Entity ---> Value Type : uni directional (From Entity ---> Value)
// CANNOT be used in JPQL DIRECTLY, has to be accessed vai owining entity.
@Embeddable
public class AdharCard {
	@Column(name = "card_number", unique = true, length = 20)
	private String cardNumber;
	@Column(name = "creation_date")
	private LocalDate creationDate;
	@Column(length = 30)
	private String location;

	public AdharCard() {
		// TODO Auto-generated constructor stub
	}

	public AdharCard(String cardNumber, LocalDate creationDate, String location) {
		super();
		this.cardNumber = cardNumber;
		this.creationDate = creationDate;
		this.location = location;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AdharCard [cardNumber=" + cardNumber + ", creationDate=" + creationDate + ", location=" + location
				+ "]";
	}

}