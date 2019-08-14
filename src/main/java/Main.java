import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Student> al=createObj();
        College cl = new College(al);
        //MARSHALLER for------->>>>>>> OBJECT ----->>>>XML
        JAXBContext jb = JAXBContext.newInstance(College.class);
        Marshaller marshaller = jb.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(cl,new FileOutputStream("HeritageCollege.xml"));
        StringWriter str = new StringWriter();
        marshaller.marshal(cl, str);
        String xml = str.toString();
        System.out.println("The output is : " + xml);
        //UNMARSHALLER FOR---->>>>>>XML ----->>>>OBJECT
        Unmarshaller ums = jb.createUnmarshaller();
        College clg = (College) ums.unmarshal(new File("HeritageCollege.xml"));
        System.out.println("Unmarshalling done----------");
        List<Student> lst = clg.getS();
        for (Student a : lst)
            System.out.println(a);

   }


    public static ArrayList<Student> createObj() throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> stud=new ArrayList<>();
        int num;
        System.out.println(("Enter the number of students :----"));
        num=sc.nextInt();
        String s;
        int roll;
        for(int i=0;i<num;i++)
        {
            System.out.println("Enter name of Student "+(i+1));
            s=sc.next();
            System.out.println("You entered "+s);
            System.out.println("enter roll of Student "+(i+1));
            roll=sc.nextInt();
            stud.add(new Student(roll,s)) ;
        }

        return stud;
    }
}