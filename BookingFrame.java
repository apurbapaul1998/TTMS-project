package grp4proj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.*;

import javax.swing.*;

public class BookingFrame extends JFrame {
	private JList<String> listlocation;
	private JList<String> listtype;
	private JTextField txtlocation, txtrtype, txtdate, txtcroom;
	private JLabel lbllocation, lblrtype, lbldate, lblcroom;
	private JButton btnnext;
	private DefaultListModel<String> listmodel;
	ArrayList<String> locationlist;
	private DefaultListModel<String> listrtype;
	ArrayList<String> typelist;
	String m;
	// Customer cs=null;

	// public BookingFrame(Customer c) {
	// this();
	// cs=c;
	// }
	public BookingFrame(String m) {
		this();
		this.m = m;

	}

	public BookingFrame() {
		super("Booking");

		Box mainbox = Box.createVerticalBox();

		Box b1 = Box.createHorizontalBox();
		lbllocation = new JLabel("Location");
		txtlocation = new JTextField(10);
		b1.add(Box.createRigidArea(new Dimension(10, 0)));
		b1.add(lbllocation);
		b1.add(Box.createRigidArea(new Dimension(25, 0)));
		b1.add(txtlocation);

		mainbox.add(Box.createRigidArea(new Dimension(0, 20)));
		mainbox.add(b1);

		Box b2 = Box.createHorizontalBox();
		lblrtype = new JLabel("Room Type");
		txtrtype = new JTextField(10);
		// Box b1=Box.createHorizontalBox();
		b2.add(Box.createRigidArea(new Dimension(10, 0)));
		b2.add(lblrtype);
		b2.add(Box.createRigidArea(new Dimension(10, 0)));
		b2.add(txtrtype);

		mainbox.add(Box.createRigidArea(new Dimension(0, 20)));
		mainbox.add(b2);

		lblcroom = new JLabel("Room");
		txtcroom = new JTextField(10);
		Box b3 = Box.createHorizontalBox();
		b3.add(Box.createRigidArea(new Dimension(10, 0)));
		b3.add(lblcroom);
		b3.add(Box.createRigidArea(new Dimension(40, 0)));
		b3.add(txtcroom);

		mainbox.add(Box.createRigidArea(new Dimension(0, 20)));
		mainbox.add(b3);

		Box b4 = Box.createHorizontalBox();
		lbldate = new JLabel("Date");
		txtdate = new JTextField(10);
		b4.add(Box.createRigidArea(new Dimension(10, 0)));
		b4.add(lbldate);
		b4.add(Box.createRigidArea(new Dimension(46, 0)));
		b4.add(txtdate);

		mainbox.add(Box.createRigidArea(new Dimension(0, 20)));
		mainbox.add(b4);

		Box b5 = Box.createHorizontalBox();
		btnnext = new JButton("NEXT");
		b5.add(btnnext);

		mainbox.add(Box.createRigidArea(new Dimension(0, 55)));
		mainbox.add(b5);

		add(mainbox);

		locationlist = new ArrayList<>();
		locationlist.add("digha");
		locationlist.add("new town");
		locationlist.add("Puri");
		locationlist.add("Murshidabad");
		locationlist.add("Darjeeling");
		locationlist.add("Sundarbon");
		locationlist.add("SaltLake");
		locationlist.add("Goa");

		listmodel = new DefaultListModel<>();
		for (String s : locationlist) {
			listmodel.addElement(s);
		}

		listlocation = new JList<>(listmodel);

		JScrollPane pane = new JScrollPane(listlocation);
		b1.add(pane);

		listlocation.addListSelectionListener(e -> {
			int pos = listlocation.getSelectedIndex();
			String location = locationlist.get(pos);
			txtlocation.setText(location);

		});
		typelist = new ArrayList<>();
		typelist.add("AC");
		typelist.add("NON-AC");

		listrtype = new DefaultListModel<>();
		for (String s1 : typelist) {
			listrtype.addElement(s1);
		}

		listtype = new JList<>(listrtype);

		JScrollPane typepane = new JScrollPane(listtype);
		b2.add(typepane);

		listtype.addListSelectionListener(e -> {
			int type = listtype.getSelectedIndex();
			String r_type = typelist.get(type);
			txtrtype.setText(r_type);
		});

		btnnext.addActionListener(e1 -> {
			String lstr = txtlocation.getText().trim();
			String typestr = txtrtype.getText().trim();
			String strcroom = txtcroom.getText().trim();
			String dstr = txtdate.getText().trim();
			int croom = Integer.parseInt(strcroom);

			try {
				byte[] bytes = Files.readAllBytes(Paths.get("roomoccupancy.dat"));

				List<RoomOccupancy> list = DBManager_hotel.loadsRoomOccupancydata();
				RoomOccupancy foundhotel = null;
				boolean book = false;

				for (RoomOccupancy h : list) {
					if (typestr.equalsIgnoreCase("AC")) {
						if ((h.getHotelloc().equalsIgnoreCase(lstr)) && (h.getRoomtype().equalsIgnoreCase(typestr))
								&& (croom <= h.getAcavailable()) && (h.getOccupancyDate().equalsIgnoreCase(dstr))) {

							book = true;
							foundhotel = h;
							break;

						}
					}
					if (typestr.equalsIgnoreCase("NON-AC")) {
						if ((h.getHotelloc().equalsIgnoreCase(lstr)) && (h.getRoomtype().equalsIgnoreCase(typestr))
								&& (croom <= h.getNonacavailable()) && (h.getOccupancyDate().equalsIgnoreCase(dstr))) {

							book = true;
							foundhotel = h;
							break;
						}
					}
				}

				if (book) {
					JOptionPane.showMessageDialog(BookingFrame.this, foundhotel.getHotelName());
					new DataEntryBooking(m, foundhotel, croom);
				} else {
					JOptionPane.showMessageDialog(BookingFrame.this, "sorry no hotel available.....:(");
				}
				if (book) {
					if (typestr.equalsIgnoreCase("AC")) {
						foundhotel.setAcavailable((foundhotel.getAcavailable() - croom));

					}
					if (typestr.equalsIgnoreCase("NON-AC")) {
						foundhotel.setNonacavailable((foundhotel.getNonacavailable() - croom));

					}
				}
				DBManager_hotel.saveRoomOccupancyData(list);

			} catch (IOException e2) {

				e2.printStackTrace();
			}
		});

		setSize(400, 600);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String args[]) {
		// String m;
		new BookingFrame();
	}
}
