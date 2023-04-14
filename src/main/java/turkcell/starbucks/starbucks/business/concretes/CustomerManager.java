package turkcell.starbucks.starbucks.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import turkcell.starbucks.starbucks.business.abstracts.FakeEDevletService;
import turkcell.starbucks.starbucks.entities.Customer;
import turkcell.starbucks.starbucks.repository.CustomerRepository;
import turkcell.starbucks.starbucks.business.abstracts.CustomerService;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetCustomerResponse;
import turkcell.starbucks.starbucks.business.dto.requests.creates.CreateCustomerRequest;
import turkcell.starbucks.starbucks.business.dto.requests.updates.UpdateCustomerRequest;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetAllCustomersResponse;
import turkcell.starbucks.starbucks.business.dto.responses.creates.CreateCustomerResponse;
import turkcell.starbucks.starbucks.business.dto.responses.updates.UpdateCustomerResponse;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final ModelMapper mapper;
    private final FakeEDevletService eDevletService;
    private final CustomerRepository repository;

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = repository.findAll();

        List<GetAllCustomersResponse> responses = customers
                .stream()
                .map(customer -> mapper.map(customer, GetAllCustomersResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = repository.findById(id).orElseThrow();

        GetCustomerResponse response = mapper.map(customer, GetCustomerResponse.class);

        return response;
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) {
        eDevletService.customerVerification(request);
        Customer customer = mapper.map(request, Customer.class);
        customer.setId(0);
        addCustomerControl(customer);
        repository.save(customer);

        CreateCustomerResponse response = mapper.map(customer, CreateCustomerResponse.class);

        return response;
    }

    @Override
    public UpdateCustomerResponse update(int id, UpdateCustomerRequest request) {
        eDevletService.customerVerification(request);
        Customer customer = mapper.map(request, Customer.class);
        customer.setId(id);
        repository.save(customer);
        UpdateCustomerResponse response = mapper.map(customer, UpdateCustomerResponse.class);

        return response;
    }

    @Override
    public void delete(int id) { repository.deleteById(id); }

    private void addCustomerControl(Customer customer){
        List<Customer> customers = repository.findAll();

        for (Customer customer1 : customers) {
            if(customer1.getIdentificationNumber().equals(customer.getIdentificationNumber()))
                throw new RuntimeException("There is a customer record.");
        }
    }
}