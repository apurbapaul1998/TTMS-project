package grp4proj;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;

public class Checkbooking extends JFrame{
	private JLabel lblmail,lblhname,lbldate;
	private JTextField txtmail,txthname,txtdate;
	private JButton btnnext;
	
	public Checkbooking() {
		super("CHECK BOOKING");
		Box mainbox = Box.createVerticalBox();

		Box b1 = Box.createHorizontalBox();
		lblmail = new JLabel("ENTER MAIL");
		txtmail = new JTextField(10);
		b1.add(Box.createRigidArea(new Dimension(10, 0)));
		b1.add(lblmail);
		b1.add(Box.createRigidArea(new Dimension(10, 0)));
		b1.add(txtmail);
		b1.add(Box.createRigidArea(new Dimension(10, 0)));
		
		Box b2 = Box.createHorizontalBox();
		lblhname = new JLabel("HOTEL NAME");
		txthname = new JTextField(10);
		b2.add(Box.createRigidArea(new Dimension(6, 0)));
		b2.add(lblhname);
		b2.add(Box.createRigidArea(new Dimension(10, 0)));
		b2.add(txthname);
		b2.add(Box.createRigidArea(new Dimension(10, 0)));
		
		Box b4 = Box.createHorizontalBox();
		lbldate = new JLabel("ENTER DATE");
		txtdate = new JTextField(10);
		b4.add(Box.createRigidArea(new Dimension(10, 0)));
		b4.add(lbldate);
		b4.add(Box.createRigidArea(new Dimension(10, 0)));
		b4.add(txtdate);
		b4.add(Box.createRigidArea(new Dimension(10, 0)));
		
		Box b3 = Box.createHorizontalBox();
		btnnext = new JButton("NEXT");
		b3.add(btnnext);
		
		mainbox.add(Box.createRigidArea(new Dimension(0, 10)));
		mainbox.add(b1);
		mainbox.add(Box.createRigidArea(new Dimension(0, 10)));
		mainbox.add(b2);
		mainbox.add(Box.createRigidArea(new Dimension(0, 10)));
		mainbox.add(b4);
		mainbox.add(Box.createRigidArea(new Dimension(0, 10)));
		mainbox.add(b3);
		add(mainbox);
		
		btnnext.addActionListener(e -> {
			String mstr = txtmail.getText().trim();
			String hstr=txthname.getText().trim();
			String dstr=txtdate.getText().trim();
			try {
				byte[] bytes = Files.readAllBytes(Paths.get("booking.dat"));
				//
				List<BookingData> list = DBManager_booking.loadsBookingdata();
				
				
				BookingData foundCustomer = null;
				boolean found = false;
				for (BookingData b : list) {
					if ((b.getMail().equalsIgnoreCase(mstr)) && (b.getHname().equalsIgnoreCase(hstr)) && (b.getDate().equalsIgnoreCase(dstr))) {
						found = true;
						foundCustomer = b;
						System.out.println("####GOT #####");
						break;
					}
				}
				if (found) {	
					JOptionPane.showMessageDialog(Checkbooking.this, "YES YOU HAVE BOOKED..."+"... THANK YOU...");
					new DataEntryBooking(foundCustomer);

				} else {
					//JOptionPane.showMessageDialog(Checkbooking.this, "invalid....SORRY.. NO BOOKING");
					//JOptionPane.showMessageDialog(Checkbooking.this, "YOU WANT TO BOOK...");
					//new CheckEmail();
					int result=JOptionPane.showConfirmDialog(Checkbooking.this,"NO BOOKING.."+"..YOU WANT TO BOOK??", "INVALID..",  JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION) {
						new CheckEmail();
					}
					
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Checkbooking cb = new Checkbooking();

	}

}
