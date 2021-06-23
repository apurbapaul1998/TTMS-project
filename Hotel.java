package grp4proj;

import java.io.Serializable;

public class Hotel implements Serializable {
	private String name;
	private String type;
	private String location;
	private int total_rooms;
	private int booked_rooms;
	private int available_rooms;

	public Hotel(String name, String type, String location, int total_rooms, int booked_rooms, int available_rooms) {
		this.name = name;
		this.type = type;
		this.location = location;
		this.total_rooms = total_rooms;
		this.booked_rooms = booked_rooms;
		this.available_rooms = available_rooms;
	}

	public Hotel() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation() {
		this.location = location;
	}

	public int getTotal_rooms() {
		return total_rooms;
	}

	public void setTotal_rooms(int total_rooms) {
		this.total_rooms = total_rooms;
	}

	public int getBooked_rooms() {
		return booked_rooms;
	}

	public void setBooked_rooms(int booked_rooms) {
		this.booked_rooms = booked_rooms;
	}

	public int getAvailable_rooms() {
		return available_rooms;
	}

	public void setAvailable_rooms(int available_rooms) {
		this.available_rooms = available_rooms;
	}

}
