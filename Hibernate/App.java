package hibernetAssignment.mayank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        
        Student st = new Student();
        List<Student>studentList= new ArrayList<Student>();
        
        System.out.println("Enter 1 for insert in Student table! ");
        System.out.println("Enter 2 for insert in Course table! ");
        System.out.println("Enter 3 for displaying all details!");
        
        Scanner in = new Scanner(System.in);
        int option = in.nextInt(); 
        System.out.println("You entered integer "+option); 
        
        if(option == 1)
        {
        	
        	System.out.println("Enter id  age1 name");
        	int id1 = in.nextInt(); 
        	int age1 = in.nextInt();
        	String buff = in.nextLine();
        	String Name1 = in.nextLine();
        	
        	 st.setStudentId(id1);
        	 st.setStudentName(Name1);
        	 st.setStudentAge(age1);
        	 
        	 session.save(st);
        	 
        	 System.out.println("Successfully added new record !"); 
        	
        }
        	       
        Course c = new Course();
        List<Course>CourseList= new ArrayList<Course>();
        
        if(option == 2)
        {
        	System.out.println("Enter courseId StudentId CourseName");
        	int cid = in.nextInt(); 
        	int sid = in.nextInt();
        	String buff = in.nextLine();
        	String cname = in.nextLine();
        	
        	 c.setCourseId(cid);
        	 c.setCourseName(cname);
        	 c.setStudentId(sid);
        	 session.save(c);
        	 System.out.println("Successfully added new record !"); 
        	
        }

        

        Criteria cr = session.createCriteria(Student.class);
        studentList=cr.list();
        
        if(option ==3)
        {
        System.out.println();
        System.out.println("Name Age Cid CourseName");
        System.out.println();
        for(Student student: studentList) {
   		  System.out.println( student.getStudentName()+"|" 
   		  +student.getStudentAge()+"|"
   		  +student.getStudentId()+"|"
   		  +(!student.getCourses().isEmpty()?student.getCourses().get(0).getCourseName()
   		  :"") ); }
        }
        session.getTransaction().commit();
        
    }

}
