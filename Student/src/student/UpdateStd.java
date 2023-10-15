package student;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import database.ConnectSql;
import login.DB;

public class UpdateStd implements ActionListener {
	JFrame frame;
	 private JLabel titel,tstdName,tstdId,tstdDob,tstdClass,tcgpa,tattendence;
	    private JTextField fstdName,fstdId,fstdDob,fstdClass,fcgpa,fattendence ;
	    private JButton updateStd,getData;
	@Override
	public void actionPerformed(ActionEvent e) {
		 frame=new JFrame("Update STudent Info");
		 frame.setSize(550,600);
			frame.setVisible(true);
			frame.setLayout(new GridLayout(10,2));
			titel = new JLabel("Edit Student Details ");
			titel.setFont(new Font("Arial", Font.BOLD, 25));
			titel.setBounds(10, 10, 400, 20);
			tstdName = new JLabel("Student Name : ");
			tstdId = new JLabel("Student ID : ");
			tstdDob = new JLabel("Student Dob : ");
			tstdClass = new JLabel("Student Class : ");
			tcgpa = new JLabel("Student CGPA : ");
			tattendence = new JLabel("Student Attendence : ");
			fstdName = new JTextField();
			fstdId = new JTextField();
			fstdDob = new JTextField();
			fstdClass = new JTextField();
			fcgpa = new JTextField();
			fattendence = new JTextField();
			updateStd =new JButton("Update Student");
			getData =new JButton("get Data");
			JLabel l=new JLabel();
			Connection connect;
			try {
				connect= ConnectSql.getConnection(DB.url,DB.usarName,DB.password);
	
			    getData.addActionListener((ActionEvent)->{
			    	
			    	String select="select * from student where stdid="+fstdId.getText()+";";
			    	try {
			    		
				   PreparedStatement  pr=connect.prepareStatement(select);
					ResultSet rs= pr.executeQuery();
					while (rs.next()) {
					System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "
			    +rs.getString(5)+" : "+rs.getString(6));
					   fstdName.setText(rs.getString(2));
					   fstdId.setText(""+rs.getInt(1));
					   fstdDob.setText(rs.getString(3));
					   fstdClass.setText(rs.getString(4));
					   fcgpa.setText(""+rs.getFloat(5));
					   fattendence.setText(""+rs.getInt(6));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					l.setText("Illegal Id ");
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					l.setText("Illegal Id ");
					e1.printStackTrace();
				}
				  
			});
			    
			    updateStd.addActionListener((ActionEvent)->{
			    	String query = "update student set stdid='"+fstdId.getText()
			    +"', stdName= '"+fstdName.getText()+"' ,stdDOB ='"+fstdDob.getText()+"',stdClass= '"
			    +fstdClass.getText()+"' ,CGPA='"+fcgpa.getText()+"' ,attendence='"+fattendence.getText()+"' where stdid='"
			    +fstdId.getText()+"'"+"; ";
			    	 try {
						PreparedStatement  pr=connect.prepareStatement(query);
						int count=pr.executeUpdate();
						if(count==1) {
							l.setText("Data Updated Successfully");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	
			    });
			
			frame.add(titel);
			frame.setLayout(new GridLayout(10,2));
			frame.add(new JLabel(""));
			frame.add(new JLabel("Fill Id & click on getData"));
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
			frame.add(updateStd);
			frame.add(getData);
			frame.add(l);
		
		
		
	    
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
	}

}
