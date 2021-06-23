package grp4proj;

import java.io.*;
import java.util.*;

public class DBManager_booking {
	public static List<BookingData> loadsBookingdata() {
		List<BookingData> list = null;
		ObjectInputStream os = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("booking.dat");
			os = new ObjectInputStream(fs);
			list = (List<BookingData>) os.readObject();
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

	public static void savaBookingData(List<BookingData> list) {
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(new FileOutputStream("booking.dat"));
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
}
