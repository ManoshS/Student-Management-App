package student;

import java.awt.Checkbox;
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

import database.ConnectSql;
import login.DB;

public class TakeAtte implements ActionListener {
	private JFrame frame,home;
	private List<String> names;
	private List<JLabel> Lnames;
	private List<Checkbox> attend;
	private List<Integer> id;
	private JLabel pre,ab;
	private JButton butn;
	public TakeAtte(JFrame home) {
	this.home=home;
	}
   
	@Override
	public void actionPerformed(ActionEvent e) {
		//home.setVisible(false);
		   frame = new JFrame("Take Attendence");
		   frame.setSize(400,600);
			frame.setVisible(true);
		
			 String query="select stdid,stdName from student;";
			Connection connect;
			Lnames=new ArrayList<>();
			attend=new ArrayList<>();
			id=new ArrayList<>();
			pre=new JLabel();
			ab=new JLabel();
			butn=new JButton("Save Attendence");
			int i=1;
			try {
				connect = ConnectSql.getConnection(DB.url,DB.usarName,DB.password);
				ResultSet rs= ConnectSql.select(query, connect);
				frame.add(new JLabel("Take Attendence"));
				frame.add(new JLabel(" "));

				frame.add(new JLabel("Student name"));
				frame.add(new JLabel("Attendence"));
				while(rs.next())
				{
					Lnames.add(new JLabel(i+" . "+ rs.getString(2)));
					attend.add(new Checkbox("Attended"));
					id.add(rs.getInt(1));
					frame.add(Lnames.get(i-1));
					frame.add(attend.get(i-1));
					i++;
				}
				frame.add(pre);
				frame.add(ab);
				frame.add(butn);
				frame.add(new JLabel(" "));
				frame.setLayout(new GridLayout(attend.size()+5,2));
				
				butn.addActionListener((ActionEvent)->{					
				String updateQuery;
				int row=0;
				for(int x=0; x<attend.size();x++) {
					if(attend.get(x).getState())
					{
						updateQuery="update student set attendence= attendence+1 where stdid="+id.get(x)+";";
						PreparedStatement pr;
						try {
							pr = connect.prepareStatement(updateQuery);
						
						 row=row+pr.executeUpdate();
						
//						pr.close();
//						connect.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				pre.setText(row+" Students Present");
				int abs=attend.size()-row;
				ab.setText(abs+" Students Absent");
				});
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
	}


}
