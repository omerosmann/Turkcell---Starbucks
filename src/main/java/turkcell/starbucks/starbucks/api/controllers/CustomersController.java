package turkcell.starbucks.starbucks.api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import turkcell.starbucks.starbucks.business.abstracts.CustomerService;
import turkcell.starbucks.starbucks.business.dto.requests.creates.CreateCustomerRequest;
import turkcell.starbucks.starbucks.business.dto.requests.updates.UpdateCustomerRequest;
import turkcell.starbucks.starbucks.business.dto.responses.creates.CreateCustomerResponse;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetAllCustomersResponse;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetCustomerResponse;
import turkcell.starbucks.starbucks.business.dto.responses.updates.UpdateCustomerResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping ("/api/customers")
public class CustomersController {
    private final CustomerService service;

    @GetMapping
    public List<GetAllCustomersResponse> getall()
    { return service.getAll(); }

    @GetMapping ("/{id}")
    public GetCustomerResponse getById(@PathVariable int id)
    { return service.getById(id); }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public CreateCustomerResponse add(@Valid  @RequestBody CreateCustomerRequest request)
    { return service.add(request); }

    @PutMapping ("/{id}")
    public UpdateCustomerResponse update(@PathVariable int id,@Valid  @RequestBody UpdateCustomerRequest request)
    { return service.update(id, request); }

    @DeleteMapping ("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id)
    { service.delete(id); }
}