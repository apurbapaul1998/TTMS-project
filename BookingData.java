package grp4proj;

import java.io.Serializable;

public class BookingData implements Serializable{
	private String mail,hname,date,rtype;
	private int room;
	
	
	public BookingData(String mail,String hname, String date, String rtype, int room) {
		this.mail=mail;
		this.hname = hname;
		this.date = date;
		this.rtype = rtype;
		this.room = room;
	}
	
	public BookingData() {
		super();
	}

	//public BookingData(Hotel h,String d,int r) {
		//mail=c.getEmail();
		//hname=h.getName();
		//date=d;
		//rtype=h.getType();
		//room=r;
	//}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	
	



}
