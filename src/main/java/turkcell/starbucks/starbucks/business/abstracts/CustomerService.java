package turkcell.starbucks.starbucks.business.abstracts;

import turkcell.starbucks.starbucks.business.dto.responses.gets.GetCustomerResponse;
import turkcell.starbucks.starbucks.business.dto.requests.creates.CreateCustomerRequest;
import turkcell.starbucks.starbucks.business.dto.requests.updates.UpdateCustomerRequest;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetAllCustomersResponse;
import turkcell.starbucks.starbucks.business.dto.responses.creates.CreateCustomerResponse;
import turkcell.starbucks.starbucks.business.dto.responses.updates.UpdateCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    GetCustomerResponse getById(int id);
    CreateCustomerResponse add(CreateCustomerRequest request);
    UpdateCustomerResponse update(int id, UpdateCustomerRequest request);
    void delete(int id);
}