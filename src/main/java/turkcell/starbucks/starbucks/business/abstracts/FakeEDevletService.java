package turkcell.starbucks.starbucks.business.abstracts;

import turkcell.starbucks.starbucks.business.dto.requests.CustomerRequest;

public interface FakeEDevletService {

    void customerVerification(CustomerRequest request);
}