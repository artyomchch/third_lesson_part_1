import DAO.Course;
import DAO.CourseDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("Hi");


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class);
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");




        CourseDAO courseDao = context.getBean(CourseDAO.class);
        for(Course c : courseDao.findAll())
            System.out.println(c);

        System.out.println("\n\n");

        for(Course c : courseDao.findByTitle("WEB"))
            System.out.println(c);

        context.close();
    }
}
