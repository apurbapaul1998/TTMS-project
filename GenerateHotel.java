package grp4proj;
import java.text.DateFormat;
import java.util.*;
public class GenerateHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Hotel> list=DBManager_hotel.loadsHoteldata();
		List<RoomOccupancy> occulist=new ArrayList<>();
		List<String> daterange=generateDateRange();
		for(Hotel h:list ) {
			for(String d:daterange) {
				occulist.add(new RoomOccupancy(h.getName(),h.getLocation(),h.getType(),d,h.getTotal_rooms(),h.getTotal_rooms()));
				
			}
			
		}
		DBManager_hotel.saveRoomOccupancyData(occulist);
		
		
		
	}
	public static List<String> generateDateRange(){
		DateFormat df=DateFormat.getDateInstance(DateFormat.SHORT) ;
		Calendar start=Calendar.getInstance();
		start.set(2020,7,1);
		
		Calendar end=Calendar.getInstance();
		end.set(2021,0,1);
		List<String> datelist=new ArrayList<>();
		while(start.compareTo(end)!=0) {
			datelist.add(df.format(start.getTime()));
			start.add(Calendar.DAY_OF_MONTH, 1);
			
		}
		return datelist;
	}

}
