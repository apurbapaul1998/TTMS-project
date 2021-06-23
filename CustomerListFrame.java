package grp4proj;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerListFrame extends JFrame{
	private JTable tblCustomerList;
    private String data[][];
    private String[] colnames= {"NAME","EMAIL_ID","PHONENO"};
    private List<Customer> list=null;
    
    public  CustomerListFrame() {
		// TODO Auto-generated constructor stub
        super("Customer Details");
        list=DBManager_cus.loadsCustomerdata();
        // creating 2d data array from list
        
        String data[][]=new String[list.size()][3];
        int row=0;
        for(Customer c:list) {
            data[row][0]=c.getName();
            data[row][1]=c.getEmail();
            data[row][2]=String.valueOf(c.getPhnno());
            row++;
        }
        tblCustomerList=new JTable(data, colnames);
        add(new JScrollPane(tblCustomerList));
        
        setSize(600,600);
        getContentPane().setBackground(new Color(51, 153, 255));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CustomerListFrame();
	}

}
