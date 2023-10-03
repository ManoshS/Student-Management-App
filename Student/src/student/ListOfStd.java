package student;

import java.awt.Checkbox;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mysql.cj.xdevapi.PreparableStatement;

import database.ConnectSql;
import login.DB;

public class ListOfStd implements ActionListener {
	private JFrame frame;
	private List<JLabel> stdNames,stdId,stdDob,stdClass,stdCgpa,stdAtt;
	private List<Checkbox> delete;
	private JButton deleteButton;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 frame = new JFrame("List of Students");
		   frame.setSize(800,700);
			frame.setVisible(true);
			
			frame.setFont(new Font("Arial", Font.BOLD, 25));
			stdNames =new ArrayList<JLabel>();
			stdId =new ArrayList<JLabel>();
			stdDob =new ArrayList<JLabel>();
			stdClass =new ArrayList<JLabel>();
			stdCgpa =new ArrayList<JLabel>();
			stdAtt =new ArrayList<JLabel>();
			delete=new ArrayList<>();
			
		   String query="select * from student;";
		  // ArrayList<String> subdata=new ArrayList<>();
		   try {
			Connection connect = ConnectSql.getConnection(DB.url,DB.usarName,DB.password);
			ResultSet rs= ConnectSql.select(query, connect);
			stdNames.add(new JLabel("Student Name"));
			stdId.add(new JLabel("Student Id"));
			stdDob.add(new JLabel("Date of Burth"));
			stdClass.add(new JLabel("Student Class"));
			stdCgpa.add(new JLabel("Student CGPA"));
			stdAtt.add(new JLabel("Student Attendence"));
			
			
			frame.add(stdNames.get(stdNames.size()-1));
			frame.add(stdId.get(stdId.size()-1));
			frame.add(stdDob.get(stdDob.size()-1));
			frame.add(stdClass.get(stdClass.size()-1));
			frame.add(stdCgpa.get(stdCgpa.size()-1));
			frame.add(stdAtt.get(stdAtt.size()-1));
			frame.add(new JLabel("Delete Opt"));
			
			while(rs.next())
			{
				 String data=rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "
			    +rs.getString(5)+" : "+rs.getString(6);
				 
				    stdNames.add(new JLabel("__"+rs.getString(2)+"__"));
					stdId.add(new JLabel(""+rs.getInt(1)+""));
					stdDob.add(new JLabel("__"+rs.getString(3)+"__"));
					stdClass.add(new JLabel("__"+rs.getString(4)+"__"));
					stdCgpa.add(new JLabel("__"+rs.getFloat(5)+"__"));
					stdAtt.add(new JLabel("__"+rs.getInt(6)+"__"));
					delete.add(new Checkbox("Delete option") );
					try {
					frame.add(stdNames.get(stdNames.size()-1));
					frame.add(stdId.get(stdId.size()-1));
					frame.add(stdDob.get(stdDob.size()-1));
					frame.add(stdClass.get(stdClass.size()-1));
					frame.add(stdCgpa.get(stdCgpa.size()-1));
					frame.add(stdAtt.get(stdAtt.size()-1));
					frame.add(delete.get(delete.size()-1));
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
				 System.out.println(data);
			}
			deleteButton=new JButton("Delete");
			frame.add(new JLabel(" "));
			frame.add(new JLabel(" "));
			frame.add(new JLabel(" "));
			frame.add(deleteButton);
			frame.add(new JLabel(" "));
			frame.add(new JLabel(" "));
			frame.add(new JLabel(" "));
			
			frame.setLayout(new GridLayout(stdNames.size()+1,7));
			deleteButton.addActionListener((ActionEvent)->{
			String deletQuery="";
			for(int i=0;i<delete.size();i++)
			{
				if(delete.get(i).getState())
				{
					deletQuery="delete from student where stdid=?;";//"+stdId.get(i+1)+"
					try(PreparedStatement  pr=connect.prepareStatement(deletQuery)){
						pr.setInt(1,Integer.parseInt(stdId.get(i+1).getText()));
						int row=pr.executeUpdate();
						 System.out.println(row +" row(s) deleted ");
					 	
					 	actionPerformed(e);
					 } catch (SQLException e1) {
					 	// TODO Auto-generated catch block
					 	e1.printStackTrace();
					 }
				 }
			 }
			 });
		} catch (Exception exce) {
			// TODO Auto-generated catch block
			exce.printStackTrace();
		}

	}

}
