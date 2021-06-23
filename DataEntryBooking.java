package grp4proj;
import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.*;


public class DataEntryBooking extends JFrame{
	private JLabel lblemail,lblhname,lbldate,lblroomtype,lblnoroom;
	private JTextField txtemail,txthname,txtdate,txtroomtype,txtnoroom;
	private JButton btnnew,btnconfirm;
	
	private List<BookingData> list=null;
	private List<Customer> clist=null;
	private List<Hotel> hlist=null;
	
	public DataEntryBooking(String m,Hotel h,String d,int r) {
		this();
		txtemail.setText(m);
		txthname.setText(h.getName());
		txtroomtype.setText(h.getType());
		txtnoroom.setText(String.valueOf(r));
		txtdate.setText(d);
	}
	
	public DataEntryBooking() {
		super("BOOKING DETAILS");
		Box mainbox=Box.createVerticalBox();
		
		Box b6=Box.createHorizontalBox();
		lblemail=new JLabel("EMAIL ID");
		txtemail=new JTextField(10);
		b6.add(Box.createRigidArea(new Dimension(10,0)));
		b6.add(lblemail);
		b6.add(Box.createRigidArea(new Dimension(10,0)));
		b6.add(txtemail);
		b6.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b1=Box.createHorizontalBox();
		lblhname=new JLabel("HOTEL NAME");
		txthname=new JTextField(10);
		b1.add(Box.createRigidArea(new Dimension(10,0)));
		b1.add(lblhname);
		b1.add(Box.createRigidArea(new Dimension(10,0)));
		b1.add(txthname);
		b1.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b2=Box.createHorizontalBox();
		lblroomtype=new JLabel("ROOM TYPE");
		txtroomtype=new JTextField(10);
		b2.add(Box.createRigidArea(new Dimension(10,0)));
		b2.add(lblroomtype);
		b2.add(Box.createRigidArea(new Dimension(10,0)));
		b2.add(txtroomtype);
		b2.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b3=Box.createHorizontalBox();
		lblnoroom=new JLabel("NO OF ROOM");
		txtnoroom=new JTextField(10);
		b3.add(Box.createRigidArea(new Dimension(10,0)));
		b3.add(lblnoroom);
		b3.add(Box.createRigidArea(new Dimension(10,0)));
		b3.add(txtnoroom);
		b3.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b4=Box.createHorizontalBox();
		lbldate=new JLabel("BOOK DATE");
		txtdate=new JTextField(10);
		b4.add(Box.createRigidArea(new Dimension(10,0)));
		b4.add(lbldate);
		b4.add(Box.createRigidArea(new Dimension(10,0)));
		b4.add(txtdate);
		b4.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b5=Box.createHorizontalBox();
		btnnew=new JButton("NEXT");
		btnconfirm=new JButton("CONFIRM");
		b5.add(Box.createRigidArea(new Dimension(10,0)));
		b5.add(btnnew);
		b5.add(btnconfirm);
		
		mainbox.add(Box.createRigidArea(new Dimension(0,20)));
		mainbox.add(b6);
		mainbox.add(Box.createRigidArea(new Dimension(0,20)));
		mainbox.add(b1);
		mainbox.add(Box.createRigidArea(new Dimension(0,20)));
		mainbox.add(b2);
		mainbox.add(Box.createRigidArea(new Dimension(0,20)));
		mainbox.add(b3);
		mainbox.add(Box.createRigidArea(new Dimension(0,20)));
		mainbox.add(b4);
		mainbox.add(Box.createRigidArea(new Dimension(0,20)));
		mainbox.add(b5);
		
		add(mainbox);
		
		
		btnnew.addActionListener(e->{
			String mstr=txtemail.getText().trim();
        	String hnamestr=txthname.getText().trim();
        	String rtypstr=txtroomtype.getText().trim();
        	String dstr=txtdate.getText().trim();
        	String nostr=txtnoroom.getText().trim();
        	
        	int nor=Integer.parseInt(nostr);
        	
        	//Double phnno=Double.parseDouble(phnstr);
        	
        	BookingData b=new BookingData(mstr,hnamestr,dstr,rtypstr,nor);
        	list.add(b);
        	txthname.setText("");
        	txtroomtype.setText("");
        	txtnoroom.setText("");
        	txtdate.setText("");
        });
		
		
		btnconfirm.addActionListener(e->{
        	if(list!=null && list.size()!=0) {
        		DBManager_booking.savaBookingData(list);
        		JOptionPane.showMessageDialog(DataEntryBooking.this, "record saved.... thank you...:)");
        	}
        });
		
		setSize(500,500);
		getContentPane().setBackground(new Color(51,204,255));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
		
		 list=DBManager_booking.loadsBookingdata();
	        if(list==null) {
	        	list=new ArrayList<>();
	        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DataEntryBooking db=new DataEntryBooking();
	}

}
