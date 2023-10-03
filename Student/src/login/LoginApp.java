package login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import database.ConnectSql;
import student.HomePage;


public class  LoginApp  extends Account{

	private JFrame frame;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton ok;
    private JButton createAccount;
    private String username;
    private String pword;
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

	public LoginApp getCurrInst() {
		return this;
    }
    
    public LoginApp() {
    	frame =new JFrame();
    	frame.setTitle("Login Page");
    	frame.setSize(300, 200);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLocationRelativeTo(null);
    	frame.setResizable(false);
        JLabel title = new JLabel("Welcome to Student Management Application");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(50, 50, 600, 100);
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 140, 400, 100);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 180, 400, 200);
        
        JLabel or = new JLabel("OR");
        or.setBounds(120, 450, 100, 50);
        
        usernameField = new JTextField(15);
        usernameField.setBounds(100, 180, 200, 30);
        
        passwordField = new JPasswordField(15);
        passwordField.setBounds(100, 270, 200, 30);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(120, 350, 100, 50);
        
        JLabel res = new JLabel("");
        res.setBounds(100, 400, 450, 30);
        
        ok=new JButton("OK");
		ok.setBounds(120, 450, 100, 50);
		
		createAccount= new JButton("Create Account");
		createAccount.setBounds(120, 520, 150, 50);
       
      //Adding all the components to the frame 
		frame.setLayout(null);
		frame.add(usernameLabel);
		frame.add(title);
		frame.add(or);
		frame.add(usernameField);
		frame.add(passwordLabel);
		frame.add(passwordField);
		frame.add(loginButton); 
		frame.add(res);
		frame.add(createAccount);
		frame.setSize(700, 650);
		
		frame.setVisible(true);
       
		createAccount.addActionListener(new CreateAccount(frame));
       loginButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               username = usernameField.getText();
                char[] password = passwordField.getPassword();
                pword =new String(password);
                System.out.println("Username: " + username);
                System.out.println("Password: " + pword);
                try {

            	String query="select * from class where userName = '"+username+"' and pasword = '"+pword+"' ;";
            	//String query0 = "insert into department values(?,?,?);";
            	
        		Connection connect=ConnectSql.getConnection(DB.url,DB.usarName,DB.password);
        		ResultSet rs=ConnectSql.select(query, connect);

            	if(rs.next()) {
        				res.setText("Login  Successful.. your name is "+rs.getString(5) +" & your class Name"+rs.getString(4));
        				frame.add(ok); 
        				frame.setVisible(false);
        				new HomePage(getCurrInst());
            	}
            	else {
            		res.setText("You do not have account so, create Account");
            		frame.add(ok); 
            		ok.addActionListener(new CreateAccount(frame));
            	}
            	connect.close();
        		
                } catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
    }
}

	
