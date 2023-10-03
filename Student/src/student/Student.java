package student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

private static final long serialVersionUID = 1L;
private String name ;
private String regno;
private String dob;
private Attendence att=new Attendence();
private List <Integer> sem=new ArrayList<>();
double avg;
public Student() {
	super();
}
public Student(String name) {
	super();
	this.name = name;
}
public Student(String name, String regno, String dob, Attendence att, List<Integer> sem) {
	super();
	this.name = name;
	this.regno = regno;
	this.dob = dob;
	this.att = att;
	this.sem = sem;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRegno() {
	return regno;
}
public void setRegno(String regno) {
	this.regno = regno;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public Attendence getAtt() {
	return att;
}
public void setAtt(Attendence att) {
	this.att = att;
}
public List<Integer> getSem() {
	return sem;
}
public void setSem(List<Integer> sem) {
	this.sem = sem;
}

void getAvg(List<Integer> li)
{
	int sum=0;
	for(Integer ele : li) {
		sum+=ele;
	}
	this.avg=sum/li.size();
	
}

//public void displayAbb()
//{
//	for(Integer ab:att.count){
//		 System.out.println(ab+" means absent");
//	 }
//}
@Override
public String toString() {
	return "Student [name=" + name + ", regno=" + regno + ", dob=" + dob + ", att=" + att + ", sem=" + sem + "]";
}


}
