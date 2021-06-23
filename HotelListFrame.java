package grp4proj;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HotelListFrame extends JFrame{
	private JTable tblHotelList;
    private String data[][];
    private String[] colnames= {"HOTEL NAME","ROOM TYPE","LOCATION","TOTAL ROOM","BOOKED ROOM","AVAILABLE ROOM"};
    
    private List<Hotel> list=null;
    
    /*public HotelListFrame(Hotel h,int croom) {
    	super("HOTEL DETAILS");
    	list=DBManager_hotel.loadsHoteldata();
    	String data[][]=new String[list.size()][6];
    	int row=0;
    	for(Hotel h1:list) {
    		if(h1.getName().equalsIgnoreCase(h.getName())) {
    			data[row][0]=h1.getName();
    			data[row][1]=h1.getType();
    			data[row][2]=h1.getLocation();
    			data[row][3]=(String.valueOf(h1.getTotal_rooms()));
    			data[row][4]=(String.valueOf(h1.getBooked_rooms()+croom));
    			data[row][5]=(String.valueOf(h1.getAvailable_rooms()-croom));
    		}
    		data[row][0]=h1.getName();
            data[row][1]=h1.getType();
            data[row][2]=h1.getLocation();
            data[row][3]=String.valueOf(h1.getTotal_rooms());
            data[row][4]=String.valueOf(h1.getBooked_rooms());
            data[row][5]=String.valueOf(h1.getAvailable_rooms());
    		row++;
    	}
    	tblHotelList=new JTable(data, colnames);
        add(new JScrollPane(tblHotelList));
        
        setSize(600,600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }*/
    
    public  HotelListFrame() {
		// TODO Auto-generated constructor stub
        super("Hotel Details");
        list=DBManager_hotel.loadsHoteldata();
        // creating 2d data array from list
        
        String data[][]=new String[list.size()][6];
        int row=0;
        for(Hotel h:list) {
            data[row][0]=h.getName();
            data[row][1]=h.getType();
            data[row][2]=h.getLocation();
            data[row][3]=String.valueOf(h.getTotal_rooms());
            data[row][4]=String.valueOf(h.getBooked_rooms());
            data[row][5]=String.valueOf(h.getAvailable_rooms());
            row++;
        }
        tblHotelList=new JTable(data, colnames);
        add(new JScrollPane(tblHotelList));
        
        setSize(600,600);
        getContentPane().setBackground(new Color(51, 153, 255));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelListFrame hf=new HotelListFrame();
	}

}