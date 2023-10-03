package student;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ClassRoom implements Serializable{

private static final long serialVersionUID = 1L;
private String name ;
private ArrayList<Student> std =new ArrayList<Student>();;
 private int numb_std= std.size();
 private String clsTeacher;
 private Date attdate;
 private List<Attendence> att=new ArrayList<Attendence>();
 public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public ArrayList<Student> getStd() {
	return std;
}
public void setStd(ArrayList<Student> std) {
	this.std = std;
}
public int getNumb_std() {
	return numb_std;
}
public void setNumb_std(int numb_std) {
	this.numb_std = numb_std;
}
public String getClsTeacher() {
	return clsTeacher;
}
public void setClsTeacher(String clsTeacher) {
	this.clsTeacher = clsTeacher;
}
public Attendence getAtt() {
	return (Attendence) att;
}
public void setAtt(List<Attendence> att) {
	this.att = (List<Attendence>) att;
}
public void takeAtt(String ...std) {
	
}

public void addStd(Student st)
{
	std.add(st);
}
public void addAllStds(ArrayList<Student> st)
{   
	for(Student std:st)
	this.std.add(std);
}
public void display()
{
	System.out.println("Student Names");
	for(Student std:this.std)
		System.out.println(std.getName());
}
public Date getAttdate() {
	return attdate;
}
public void setAttdate(Date attdate) {
	this.attdate = attdate;
}
@Override
public String toString() {
	return "ClassRoom [name=" + name + ", std=" + std + ", numb_std=" + numb_std + ", clsTeacher=" + clsTeacher
			+ ", attdate=" + attdate + ", att=" + att + "]";
}


}
