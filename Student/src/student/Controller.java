package student;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//
//public class Controller {
//	Student std;
//	ClassRoom cls;
//	void control()
//	{
//		std=new Student();
//		std.setName("Manosh");
//		cls=new ClassRoom();
//
//		cls.addStd(std);
//	   cls.addStd(new Student("Rakesh"));
//		cls.addStd(new Student("Ramesh"));
//		cls.addStd(new Student("Rama"));
//		cls.display();
//		System.out.println(cls.getStd().get(0));
//		cls.takeAtt(cls.getStd().get(0),cls.getStd().get(1));
//
//		System.out.println(cls);
//	}
//
//	public void save() throws FileNotFoundException, IOException
//	{
//		try (ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
//			objout.writeObject(std);
//			objout.writeObject(cls);
//			objout.close();
//		}
//		
//	}
//	public void getdata() throws FileNotFoundException, IOException
//	{
//		try (ObjectInputStream objin = new ObjectInputStream(new FileInputStream("file.txt"))) {
//			try {
//				std=(Student) objin.readObject();
//				cls=(ClassRoom) objin.readObject();
//			} catch (ClassNotFoundException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(cls);
//			objin.close();
//		}
//	}
//}
