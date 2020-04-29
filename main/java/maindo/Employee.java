package maindo;

public class Employee {
	String city;
	String peoplecount;
	int monry;
	
	public Employee(String city, String peoplecount,int money) {
		super();
		this.city = city;
		this.peoplecount = peoplecount;
		this.monry = money;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPeoplecount() {
		return peoplecount;
	}
	public void setPeoplecount(String peoplecount) {
		this.peoplecount = peoplecount;
	}
	public int getMonry() {
		return monry;
	}
	public void setMonry(int monry) {
		this.monry = monry;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
