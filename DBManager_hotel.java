package grp4proj;

import java.io.*;
import java.util.*;

public class DBManager_hotel {
	public static List<Hotel> loadsHoteldata() {
		List<Hotel> list = null;
		ObjectInputStream os = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("hoteldetails.dat");
			os = new ObjectInputStream(fs);
			list = (List<Hotel>) os.readObject();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		} finally {
			try {
				if (os != null)
					os.close();
				if (fs != null)
					fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public static void saveHotelData(List<Hotel> list) {
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(new FileOutputStream("hoteldetails.dat"));
			if (list != null && list.size() != 0)
				os.writeObject(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static List<RoomOccupancy> loadsRoomOccupancydata() {
		List<RoomOccupancy> list = null;
		ObjectInputStream os = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("roomoccupancy.dat");
			os = new ObjectInputStream(fs);
			list = (List<RoomOccupancy>) os.readObject();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		} finally {
			try {
				if (os != null)
					os.close();
				if (fs != null)
					fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public static void saveRoomOccupancyData(List<RoomOccupancy> list) {
		ObjectOutputStream os=null;
		try {
			os=new ObjectOutputStream(new FileOutputStream("roomoccupancy.dat"));
			if(list!=null && list.size()!=0) {
				os.writeObject(list);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

