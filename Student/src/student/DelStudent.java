package student;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import database.ConnectSql;
import login.DB;

public class DelStudent implements ActionListener {
	private JFrame frame,home;
	private JLabel title,stdNameL,stdIdL,del;
	private JTextField stdNamef,stdIdf;
	private JButton but;
	public DelStudent(JFrame home) {
		this.home=home;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//home.setVisible(false);
		frame = new JFrame("Attendence of Student");
		frame.setSize(400,500);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(5,2));
	    title=new JLabel("Deleting the Student");
	    title.setFont(new Font("Arial", Font.BOLD, 25));
		stdNameL=new JLabel("Enter Student Name :");
		stdIdL=new JLabel("Enter Student ID :");
		del=new JLabel(" ");
		stdNamef=new JTextField();
		stdIdf=new JTextField();
		but=new JButton("Delete");
		frame.add(title);
		frame.add(new JLabel(" "));
		frame.add(new JLabel(" "));
		frame.add(new JLabel(" "));
		frame.add(stdNameL);
		frame.add(stdNamef);
		frame.add(stdIdL);
		frame.add(stdIdf);
		frame.add(but);
		frame.add(del);
		but.addActionListener((ActionEvent)->{
			
			String deletQuery="delete from student where stdid=?;";//"+stdId.get(i+1)+"
			try {
				Connection connect = ConnectSql.getConnection(DB.url,DB.usarName,DB.password);
			
			PreparedStatement  pr=connect.prepareStatement(deletQuery);
				
				pr.setInt(1,Integer.parseInt(stdIdf.getText()));
				int row=pr.executeUpdate();
				 System.out.println(row +" row(s) deleted ");
			 	del.setText("Deleted Scuuessfully");
			 	
		} catch (SQLException e1) {
			 	// TODO Auto-generated catch block
			del.setText("there was a error");
			 	e1.printStackTrace();
			 } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		);
		

	}

}
