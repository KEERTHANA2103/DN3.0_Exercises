package DependencyInjectionExample;
public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create the concrete repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Create the service with dependency injection
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        Customer customer = customerService.getCustomerById(1);

        // Print customer details
        System.out.println("Customer Details:");
        System.out.println("ID: " + customer.getId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
    }
}