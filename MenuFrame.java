package grp4proj;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class MenuFrame extends JFrame {

	private JLabel lblname;
	private JMenu mnunew, mnubtdetails, mnuhtdetails, mnuctdetails, mnudtdetails;
	private JMenuItem mitemCNew, mitemhnew, mitemhtdetails, mitemcdetails,mitembookingdetails,mitembookingcheck,mitemroomdetails;
	private JMenuBar bar;

	public MenuFrame() {
		//super("TOURS & TRAVEL MANAGEMENT SYSTEM");
		lblname=new JLabel("TOURS & TRAVEL MANAGEMENT SYSTEM");
		getContentPane().add(lblname);
		lblname.setFont(new Font("Cracked", Font.ITALIC,25));
		
		bar = new JMenuBar();
		mnunew = new JMenu("NEW");
		mnuctdetails = new JMenu("CUSTOMER DETAILS");
		mnuhtdetails = new JMenu("HOTEL DETAILS");
		mnubtdetails = new JMenu("BOOKING DETAILS");
		mnudtdetails = new JMenu("LOG BOOK");
		mitemCNew = new JMenuItem("ADD NEW CUSTOMER");
		mitemhnew = new JMenuItem("ADD NEW HOTEL");
		mitemhtdetails = new JMenuItem("HOTEL DETAILS");
		mitemcdetails = new JMenuItem("CUSTOMER DETAILS");
		mitembookingdetails=new JMenuItem("BOOKING TABLE");
		mitembookingcheck=new JMenuItem("CHECK BOOKING");
		mitemroomdetails=new JMenuItem("ROOM DETAILS");
		
		mnunew.add(mitemCNew);
		mnunew.add(mitemhnew);
		mnuctdetails.add(mitemcdetails);
		mnuhtdetails.add(mitemhtdetails);
		mnubtdetails.add(mitembookingdetails);
		mnubtdetails.add(mitembookingcheck);
		mnudtdetails.add(mitemroomdetails);
		
		mitemCNew.addActionListener(e -> {
			new CheckEmail();
		});

		mitemhnew.addActionListener(e -> {
			new DataEntryHotel();
		});

		mitemcdetails.addActionListener(e -> {
			new CustomerListFrame();
		});

		mitemhtdetails.addActionListener(e -> {
			new HotelListFrame();
		});
		
		mitembookingdetails.addActionListener(e->{
			new BookingListFrame();
		});
		
		mitembookingcheck.addActionListener(e->{
			new Checkbooking();
		});
		
		mitemroomdetails.addActionListener(e->{
			new RoomOccupancyListFrame();
		});

		bar.add(mnunew);
		bar.add(mnuctdetails);
		bar.add(mnuhtdetails);
		bar.add(mnubtdetails);
		bar.add(mnudtdetails);

		setJMenuBar(bar);

		
		setSize(600,600);
		getContentPane().setBackground(new Color(51, 153, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		MenuFrame mf = new MenuFrame();

	}

}