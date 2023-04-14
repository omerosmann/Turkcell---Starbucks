package turkcell.starbucks.starbucks.adapters;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import turkcell.starbucks.starbucks.business.dto.requests.CustomerRequest;
import turkcell.starbucks.starbucks.entities.Customer;
import turkcell.starbucks.starbucks.business.abstracts.EDevletService;
import turkcell.starbucks.starbucks.repository.EDevletRepository;

@Service
@AllArgsConstructor
public class EDevletAdapter implements EDevletService {
    private final ModelMapper mapper;
    private final EDevletRepository repository;
    @Override
    public void customerVerification(CustomerRequest request) {
        Customer customer = mapper.map(request, Customer.class);

        boolean validation = repository.existsByNameAndLastNameAndOfDateBirthAndIdentificationNumber
                (customer.getName(), customer.getLastName(), customer.getOfDateBirth(), customer.getIdentificationNumber());

        if (!validation) throw new RuntimeException("Failed to Verify User Information.");
    }
}
