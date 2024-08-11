import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class Main {
    public static void main(String[] args) {
        // Load the Spring context from the applicationContext.xml file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Retrieve the BookService bean and call the manageBooks method
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.manageBooks();
    }
}