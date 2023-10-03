package student;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import login.Account;

public class HomePage  {
JFrame home;
JLabel title,addStd,delStd,takeAttend,displayStdI;
JButton add,del,atte,displayStdIB;
Account acc;	
public HomePage (Account acc){
	   this.acc=acc;
	   home=new JFrame("Home");
        home.setVisible(true);
        home.setLayout(new GridLayout(6,2));
        home.setSize(700, 650);
        home.setResizable(false);
        home.setLayout(null);
        title = new JLabel(acc.getUsername()+" Welcome to Student Management Application");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(10, 10, 650, 20);
        takeAttend= new JLabel("To Take Attendence");
        takeAttend.setBounds(20, 100, 250, 20);
        takeAttend.setFont(new Font("Arial", Font.BOLD, 25));
        atte =new JButton("Click Me");
        atte.setBounds(20, 150, 100, 50);
        
        addStd= new JLabel("To Add Student ");
        addStd.setBounds(20, 250, 250, 20);
        addStd.setFont(new Font("Arial", Font.BOLD, 25));
        add =new JButton("Click Me");
        add.setBounds(20, 300, 100, 50);
        
         delStd= new JLabel("To Delete Student ");
        delStd.setBounds(20, 380, 250, 20);
        delStd.setFont(new Font("Arial", Font.BOLD, 25));
        del = new JButton("Click Me");
        del.setBounds(20, 420, 100, 50);
        
        displayStdI= new JLabel("List Students Info");
        displayStdI.setBounds(20, 500, 250, 20);
        displayStdI.setFont(new Font("Arial", Font.BOLD, 25));
        displayStdIB = new JButton("Click Me");
        displayStdIB.setBounds(20, 530, 100, 50);
        
        home.add(title);
        home.add(new JLabel(""));
        home.add(takeAttend);
        home.add(atte);
        home.add(addStd);
        home.add(add);
        home.add(delStd);      
        home.add(del);
        home.add(delStd);      
        home.add(del);
        home.add(displayStdI);      
        home.add(displayStdIB);
        
        add.addActionListener(new AddStudent(home));
        del.addActionListener(new DelStudent(home));
        atte.addActionListener(new TakeAtte(home));
        displayStdIB.addActionListener(new ListOfStd());
        
        
        

	}


}
