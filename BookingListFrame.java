package grp4proj;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BookingListFrame extends JFrame{
	private JTable tblbookingList;
    private String data[][];
    private String[] colnames= {"MAIL ID","HOTEL NAME","DATE","ROOMTYPE","NO OF ROOM"};
    private List<BookingData> list=null;
    
    public  BookingListFrame() {
		// TODO Auto-generated constructor stub
        super("Booking Details");
        list=DBManager_booking.loadsBookingdata();
        // creating 2d data array from list
        
        String data[][]=new String[list.size()][5];
        int row=0;
        for(BookingData b:list) {
        	data[row][0]=b.getMail();
            data[row][1]=b.getHname();
            data[row][2]=b.getDate();
            data[row][3]=b.getRtype();
            data[row][4]=String.valueOf(b.getRoom());
            row++;
        }
        tblbookingList=new JTable(data, colnames);
        add(new JScrollPane(tblbookingList));
        
        setSize(600,600);
        getContentPane().setBackground(new Color(51, 153, 255));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookingListFrame bf=new BookingListFrame();
	}

}

