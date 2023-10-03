package student;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import database.ConnectSql;
import login.DB;

public class AddStudent implements ActionListener {
    private JFrame frame,home;
    private JLabel titel,tstdName,tstdId,tstdDob,tstdClass,tcgpa,tattendence;
    private JTextField fstdName,fstdId,fstdDob,fstdClass,fcgpa,fattendence ;
    private JButton addstd;
    private Connection connect;
   public AddStudent(JFrame home) {
		this.home=home;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//home.setVisible(false);
		frame = new JFrame("Add Student");
		frame.setSize(550,600);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(10,2));
		titel = new JLabel("Enter Student Details ");
		titel.setFont(new Font("Arial", Font.BOLD, 25));
		titel.setBounds(10, 10, 400, 20);
		tstdName = new JLabel("Enter Student Name : ");
		tstdId = new JLabel("Enter Student ID : ");
		tstdDob = new JLabel("Enter Student Dob : ");
		tstdClass = new JLabel("Enter Student Class : ");
		tcgpa = new JLabel("Enter Student CGPA : ");
		tattendence = new JLabel("Enter Student Attendence : ");
		
		fstdName = new JTextField();
		fstdId = new JTextField();
		fstdDob = new JTextField();
		fstdClass = new JTextField();
		fcgpa = new JTextField();
		fattendence = new JTextField();
		addstd =new JButton("Add Student");
		JLabel l=new JLabel();
		
		
		frame.add(titel);
		frame.setLayout(new GridLayout(10,2));
		frame.add(new JLabel(""));
		frame.add(new JLabel(""));
		frame.add(new JLabel(""));
		frame.add(tstdName);
		frame.add(fstdName);
		frame.add(tstdId);
		frame.add(fstdId );
		frame.add(tstdDob);
		frame.add(fstdDob);
		frame.add(tstdClass);
		frame.add(fstdClass);
		frame.add(tcgpa);
		frame.add(fcgpa);
		frame.add(tattendence);
		frame.add(fattendence);
		frame.add(addstd);
		frame.add(l);

		addstd.addActionListener((ActinoEvent)->{
			String query = "insert into student values(?,?,?,?,?,?);";
			
			try {
				
				connect = ConnectSql.getConnection(DB.url,DB.usarName,DB.password);
				
	          	PreparedStatement ps= connect.prepareStatement(query);
	          	ps.setString(1,fstdId.getText());
	      	    ps.setString(2, fstdName.getText());    
				ps.setString(3, fstdDob.getText());
				ps.setString(4, fstdClass.getText());
				ps.setString(5, fcgpa.getText());
				ps.setString(6, fattendence.getText());
				int count=ps.executeUpdate();
				l.setText(" inserted Successfully");
				System.out.println(count+" rows inserted");
				connect.close();
				ps.close();
				connect.close();
				} catch (Exception e1) {
					l.setText("There is a error ");
					e1.printStackTrace();
				}
		});

	}

}
