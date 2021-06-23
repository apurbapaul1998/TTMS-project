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

import java.awt.Dimension;

public class CheckEmail extends JFrame {
	private JLabel lblmail;
	private JTextField txtmail;
	private JButton btnnext;

	public CheckEmail() {
		super("CHECK CUSTOMER");
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
		btnnext = new JButton("NEXT");
		b2.add(btnnext);

		mainbox.add(Box.createRigidArea(new Dimension(0, 10)));
		mainbox.add(b1);
		mainbox.add(Box.createRigidArea(new Dimension(0, 10)));
		mainbox.add(b2);
		add(mainbox);

		btnnext.addActionListener(e -> {
			String mstr = txtmail.getText().trim();
			try {
				byte[] bytes = Files.readAllBytes(Paths.get("customer.dat"));
				//
				List<Customer> list = DBManager_cus.loadsCustomerdata();
				Customer foundCustomer = null;
				boolean found = false;
				for (Customer c : list) {
					if (c.getEmail().equalsIgnoreCase(mstr)) {
						found = true;
						foundCustomer = c;
						System.out.println("####GOT #####");
						break;
					}
				}
				if (found) {
					JOptionPane.showMessageDialog(CheckEmail.this, "already exists....");
					new DataEntryCustomer(foundCustomer);

				} else {
					JOptionPane.showMessageDialog(CheckEmail.this, "invalid....");
					new DataEntryCustomer();
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
		CheckEmail cm = new CheckEmail();

	}

}
