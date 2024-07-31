package DependencyInjectionExample;
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // For demonstration, returning a mock customer
        return new Customer(id, "John Doe", "john.doe@example.com");
    }
}