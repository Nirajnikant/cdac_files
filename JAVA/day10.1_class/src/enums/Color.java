package enums;

public enum Color {
	RED(40), GREEN(25), BLUE(35);
	//state : preference
	private int preference;
	//ctor
	Color(int preference) {
		this.preference = preference; //compiler err line 4
		// if u write only this one because if u write only this much the constructor was only with name and 
//		ordinal but it doesn't know about preference  
//		how to solve : associate the preference with color 
	}
	//can you add method : setter/getters/Business Logic method : yes
	//setter
	public void setPreference(int preference) {
		this.preference = preference;
	}
	//getter
	public int getPreference() {
		return preference;
	}
	//toString
	@Override
	public String toString() {
		return name().toLowerCase();
	}
}