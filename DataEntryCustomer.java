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

public class DataEntryCustomer extends JFrame{
	private JLabel lblname,lblphnno,lblemailid;
	private JTextField txtname,txtphnno,txtemailid;
	private JButton btnsave,btnnew,btndiscard,btncheckin,btncheckout;
	
	private List<Customer> list=null;
	String m;
	
	public DataEntryCustomer(Customer c) {
		this();
		txtname.setText(c.getName());
		txtemailid.setText(c.getEmail());
		txtphnno.setText(c.getPhnno());
		m=c.getEmail();
	}
	public DataEntryCustomer() {
		super("Customer Details");
		Box mainbox=Box.createVerticalBox();
		
		lblname=new JLabel("NAME");
		txtname=new JTextField(10);
		Box b1=Box.createHorizontalBox();
        b1.add(Box.createRigidArea(new Dimension(10,0)));
        b1.add(lblname);
        b1.add(Box.createRigidArea(new Dimension(10,0)));
        b1.add(txtname);
        b1.add(Box.createRigidArea(new Dimension(10,0)));
        
        lblemailid=new JLabel("MAIL ID");
		txtemailid=new JTextField(10);
		Box b2=Box.createHorizontalBox();
        b2.add(Box.createRigidArea(new Dimension(10,0)));
        b2.add(lblemailid);
        b2.add(Box.createRigidArea(new Dimension(10,0)));
        b2.add(txtemailid);
        b2.add(Box.createRigidArea(new Dimension(10,0)));
        
        Box b3=Box.createHorizontalBox();
        lblphnno=new JLabel("PHONE NO");
        txtphnno=new JTextField(10);
        b3.add(Box.createRigidArea(new Dimension(10,0)));
        b3.add(lblphnno);
        b3.add(Box.createRigidArea(new Dimension(6,0)));
        b3.add(txtphnno);
        b3.add(Box.createRigidArea(new Dimension(10,0)));
        
        Box b4=Box.createHorizontalBox();
        btnnew=new JButton("ADD NEW");
        btnsave=new JButton("SAVE");
        btndiscard=new JButton("DISCARD");
        btncheckin=new JButton("CHECK IN");
        btncheckout=new JButton("CHECK OUT");
        b4.add(btnnew);
        b4.add(btnsave);
        b4.add(btndiscard);
        b4.add(btncheckin);
        b4.add(btncheckout);
        
        mainbox.add(Box.createRigidArea(new Dimension(0,30)));
        mainbox.add(b1);
        mainbox.add(Box.createRigidArea(new Dimension(0,20)));
        mainbox.add(b2);
        mainbox.add(Box.createRigidArea(new Dimension(0,20)));
        mainbox.add(b3);
        mainbox.add(Box.createRigidArea(new Dimension(0,55)));
        mainbox.add(b4);
        
        add(mainbox);
        
        btnnew.addActionListener(e->{
        	String namestr=txtname.getText().trim();
        	String mailstr=txtemailid.getText().trim();
        	String phnstr=txtphnno.getText().trim();
        	
        	//Double phnno=Double.parseDouble(phnstr);
        	
        	Customer cs=new Customer(namestr,mailstr,phnstr);
        	list.add(cs);
        	txtname.setText("");
        	txtemailid.setText("");
        	txtphnno.setText("");
        	
        });
        btnsave.addActionListener(e->{
        	if(list!=null && list.size()!=0) {
        		DBManager_cus.savaCustomerData(list);
        		JOptionPane.showMessageDialog(DataEntryCustomer.this, "record saved.... thank you...:)");
        	}
        });
        
        btncheckin.addActionListener(e->{
        	new BookingFrame(m);
        });
        setSize(500,500);
        getContentPane().setBackground(new Color(255,255,0));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        list=DBManager_cus.loadsCustomerdata();
        if(list==null) {
        	list=new ArrayList<>();
        }
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataEntryCustomer df_cus=new DataEntryCustomer();

	}

}
