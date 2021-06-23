package grp4proj;

import java.io.Serializable;

public class RoomOccupancy implements Serializable {
	private String hotelName,hotelloc,occupancyDate,roomtype;
	private int actotal,acavailable,nonactotal,nonacavailable;
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelloc() {
		return hotelloc;
	}
	public void setHotelloc(String hotelloc) {
		this.hotelloc = hotelloc;
	}
	public String getOccupancyDate() {
		return occupancyDate;
	}
	public void setOccupancyDate(String occupancyDate) {
		this.occupancyDate = occupancyDate;
	}
	
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public int getActotal() {
		return actotal;
	}
	public void setActotal(int actotal) {
		this.actotal = actotal;
	}
	public int getAcavailable() {
		return acavailable;
	}
	public void setAcavailable(int acavailable) {
		this.acavailable = acavailable;
	}
	public int getNonactotal() {
		return nonactotal;
	}
	public void setNonactotal(int nonactotal) {
		this.nonactotal = nonactotal;
	}
	public int getNonacavailable() {
		return nonacavailable;
	}
	public void setNonacavailable(int nonacavailable) {
		this.nonacavailable = nonacavailable;
	}
	public RoomOccupancy(String hotelName,String hotelloc, String roomtype, String occupancyDate, int actotal, int nonactotal) {
		super();
		this.hotelName = hotelName;
		this.hotelloc=hotelloc;
		this.roomtype=roomtype;
		this.occupancyDate = occupancyDate;
		this.actotal = actotal;
		this.nonactotal = nonactotal;
		acavailable=this.actotal;
		nonacavailable=this.nonactotal;
	}
	public RoomOccupancy() {
		super();
	}
	

}
