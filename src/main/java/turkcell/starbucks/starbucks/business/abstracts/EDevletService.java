package turkcell.starbucks.starbucks.business.abstracts;

import turkcell.starbucks.starbucks.business.dto.requests.CustomerRequest;

public interface EDevletService {
    void customerVerification(CustomerRequest request);
}