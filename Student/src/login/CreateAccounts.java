package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.ConnectSql;
import student.HomePage;

class CreateAccount extends Account implements ActionListener{
	 private JFrame signin;
	 JFrame l;
	 private String username;
	 private String pword;
	CreateAccount(JFrame l)
	{
	this.l=l;	
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		signin=new JFrame("Create Account");
		l.setVisible(false);
		signin.setVisible(true);
		signin.setSize(500,500);
		signin.setLayout(null);
		JTextField usernameField1,className,classNo;
	    JPasswordField passwordField1;
	    JPasswordField passwordField2;
	    JButton loginButton1;
	    signin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    signin.setLocationRelativeTo(null);

	        
	        JLabel title1 = new JLabel("Welcome to Student Management Application");
	        title1.setFont(new Font("Arial", Font.BOLD, 25));
	        title1.setBounds(50, 50, 600, 100);
	        
	        JLabel usernameLabel1 = new JLabel("Username:");
	        usernameLabel1.setBounds(20, 140, 400, 100);
	        
	        JLabel passwordLabel1 = new JLabel("Create Password:");
	        passwordLabel1.setBounds(20, 180, 400, 200);
	        
	        JLabel passwordLabel2 = new JLabel("ReEnter Password:");
	        passwordLabel2.setBounds(20, 225, 400, 200);
	        
	        JLabel classnameLabel1 = new JLabel("your class name:");
	        classnameLabel1.setBounds(20, 320, 400, 100);
	        
	        JLabel classNoLabel1 = new JLabel("your class No :");
	        classNoLabel1.setBounds(20, 355, 400, 100);
	        
	        usernameField1 = new JTextField(15);
	        usernameField1.setBounds(200, 180, 200, 30);
	        
	        passwordField1 = new JPasswordField(15);
	        passwordField1.setBounds(200, 270, 200, 30);
	        
	        passwordField2 = new JPasswordField(15);
	        passwordField2.setBounds(200, 310, 200, 30);
	        
	        loginButton1 = new JButton("Login");
	        loginButton1.setBounds(180, 430, 100, 50);
	        
	        className = new JTextField(15);
	        className.setBounds(200, 350, 200, 30);
	        classNo = new JTextField(15);
	        classNo.setBounds(200, 390, 200, 30);
	        JLabel res1 = new JLabel("");
	        res1.setBounds(130, 480, 250, 30);
	        // Create a panel for components
	        signin.setResizable(false);
	        signin.setLayout(null);
	      signin.add(usernameLabel1);
	      signin.add(title1);
	      signin.add(usernameField1);
	      usernameField1.setText("");
	      signin.add(passwordLabel1);
	       signin.add(passwordField1);
	       signin.add(res1);
	       signin.add(passwordLabel2);
	       signin.add(passwordField2);
	       passwordField2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				if(new String(passwordField1.getPassword()).equals(new String(passwordField2.getPassword())))
				{
					res1.setForeground(new Color(10,100,100));
					res1.setText("Password is Correct");
					
					
				}
				else {
					res1.setForeground(new Color(240, 0, 0));
					res1.setText("Password is InCorrect");
					
				}
				
			}
	    	   
	       });
	       signin.add(new JLabel()); // Empty label for spacing
	       signin.add(loginButton1);
	       signin.add(classnameLabel1);
	       signin.add(classNo);
	      classNo.setText("");
	       signin.add(className);
	       className.setText("");
	       signin.add(classNoLabel1);
	       signin.setSize(700, 650);
	       
	       loginButton1.addActionListener((action)->{
	    	   System.out.println(usernameField1.getText());
	    	   if(usernameField1.getText().equals("")||classNo.getText().equals("")||className.getText().equals("")||passwordField1.getPassword().length==0||passwordField1.getPassword().length==0)
	    	   {
	    		   res1.setText("Fill All the fields");
	    		   res1.setForeground(new Color(240, 0, 0));
	    	   }
	    	   else {
	    	   res1.setText("Account created successfully... ");
   		   res1.setForeground(new Color(0, 10,100));
   		   username=usernameField1.getText();
   		   pword=new String(passwordField1.getPassword());
   		   String clsno=classNo.getText();
   		   String clsName=className.getText();
   		   String techName=username;
          	   String query0 = "insert into class values(?,?,?,?,?);";
          	Connection connect;
			try {
			connect = ConnectSql.getConnection(DB.url,DB.usarName,DB.password);
			
          	PreparedStatement ps= connect.prepareStatement(query0);
          	ps.setString(1,clsno);
      	    ps.setString(2, username);    
			ps.setString(3, pword);
			ps.setString(4, clsName);
			ps.setString(5, techName);
			int count=ps.executeUpdate();
			System.out.println(count+" rows inserted");
			connect.close();
			ps.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			signin.setVisible(false);
			new HomePage(this);
	    	   }
	       });
	       
	}
	
		
	}
