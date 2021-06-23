package grp4proj;

import java.io.Serializable;

public class Customer implements Serializable{
	private String name;
	private String email;
	private String phnno;
	
	public Customer(String name, String email, String phnno) {
		this.name = name;
		this.email = email;
		this.phnno = phnno;
	}
	public Customer() {
		super();
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
	public String getPhnno() {
		return phnno;
	}
	public void setPhnno(String phnno) {
		this.phnno = phnno;
	}
	
	

}
