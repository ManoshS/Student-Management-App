package student;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Attendence implements Serializable  {

	private static final long serialVersionUID = -6712495286108944216L;
public Map<Student,Integer> count=new HashMap<>();
 public void displayabsentes() {

 }
@Override
public String toString() {
	return "Attendence [count=" + count + "]";
}
}
