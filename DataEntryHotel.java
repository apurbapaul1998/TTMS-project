package grp4proj;
import java.awt.Color;
import java.awt.Dimension;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class DataEntryHotel extends JFrame{
	JLabel lblname,lbltype,lblloc,lbltotal,lblbook,lblavai;
	JTextField txtname,txttype,txtloc,txttotal,txtbook,txtavai;
	JButton btnnew,btnsave,btndiscard;
	
	private List<Hotel> list=null;
	
	
	
	public DataEntryHotel() {
		super("Hotel Details");
		Box mainbox=Box.createVerticalBox();
		
		Box b1=Box.createHorizontalBox();
		lblname=new JLabel("Hotel Name");
		txtname=new JTextField(10);
		b1.add(Box.createRigidArea(new Dimension(10,0)));
		b1.add(lblname);
		b1.add(Box.createRigidArea(new Dimension(10,0)));
		b1.add(txtname);
		b1.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b2=Box.createHorizontalBox();
		lbltype=new JLabel("Room Type");
		txttype=new JTextField(10);
		b2.add(Box.createRigidArea(new Dimension(10,0)));
		b2.add(lbltype);
		b2.add(Box.createRigidArea(new Dimension(10,0)));
		b2.add(txttype);
		b2.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b3=Box.createHorizontalBox();
		lblloc=new JLabel("Location");
		txtloc=new JTextField(10);
		b3.add(Box.createRigidArea(new Dimension(10,0)));
		b3.add(lblloc);
		b3.add(Box.createRigidArea(new Dimension(10,0)));
		b3.add(txtloc);
		b3.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b4=Box.createHorizontalBox();
		lbltotal=new JLabel("Total Room");
		txttotal=new JTextField(10);
		b4.add(Box.createRigidArea(new Dimension(10,0)));
		b4.add(lbltotal);
		b4.add(Box.createRigidArea(new Dimension(10,0)));
		b4.add(txttotal);
		b4.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b5=Box.createHorizontalBox();
		lblbook=new JLabel("No.of book");
		txtbook=new JTextField(10);
		b5.add(Box.createRigidArea(new Dimension(10,0)));
		b5.add(lblbook);
		b5.add(Box.createRigidArea(new Dimension(10,0)));
		b5.add(txtbook);
		b5.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b6=Box.createHorizontalBox();
		lblavai=new JLabel("Free Room");
		txtavai=new JTextField(10);
		b6.add(Box.createRigidArea(new Dimension(10,0)));
		b6.add(lblavai);
		b6.add(Box.createRigidArea(new Dimension(10,0)));
		b6.add(txtavai);
		b6.add(Box.createRigidArea(new Dimension(10,0)));
		
		Box b7=Box.createHorizontalBox();
		btnnew=new JButton("ADD NEW");
		btnsave=new JButton("SAVE");
		btndiscard=new JButton("DISCARD");
		b7.add(btnnew);
		b7.add(btnsave);
		b7.add(btndiscard);
		
		mainbox.add(Box.createRigidArea(new Dimension(0,30)));
		mainbox.add(b1);
		mainbox.add(Box.createRigidArea(new Dimension(0,30)));
		mainbox.add(b2);
		mainbox.add(Box.createRigidArea(new Dimension(0,30)));
		mainbox.add(b3);
		mainbox.add(Box.createRigidArea(new Dimension(0,30)));
		mainbox.add(b4);
		mainbox.add(Box.createRigidArea(new Dimension(0,30)));
		mainbox.add(b5);
		mainbox.add(Box.createRigidArea(new Dimension(0,30)));
		mainbox.add(b6);
		mainbox.add(Box.createRigidArea(new Dimension(0,30)));
		mainbox.add(b7);
		add(mainbox);
		
		btnnew.addActionListener(e->{
			String hnamestr=txtname.getText().trim();
			String typestr=txttype.getText().trim();
			String locstr=txtloc.getText().trim();
			String totalroomstr=txttotal.getText().trim();
			String bookstr=txtbook.getText().trim();
			String avaistr=txtavai.getText().trim();
			
			
			int totalroom=Integer.parseInt(totalroomstr);
			int bookroom=Integer.parseInt(bookstr);
			int avairoom=Integer.parseInt(avaistr);
			
			Hotel h=new Hotel(hnamestr,typestr,locstr,totalroom,bookroom,avairoom);
			
			list.add(h);
			txtname.setText("");
			txttype.setText("");
			txtloc.setText("");
			txttotal.setText("");
			txtbook.setText("");
			txtavai.setText("");
		});
		
		btnsave.addActionListener(e->{
			if(list!=null && list.size()!=0) {
				DBManager_hotel.saveHotelData(list);
				JOptionPane.showMessageDialog(DataEntryHotel.this,"Hotel record saved...:)");
			}
		});
		
		
		setSize(400, 600);
		getContentPane().setBackground(new Color(0,255,51));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		list=DBManager_hotel.loadsHoteldata();
		if(list==null) {
			list=new ArrayList<>();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataEntryHotel dh=new DataEntryHotel();
	}

}
