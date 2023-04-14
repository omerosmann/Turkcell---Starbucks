package turkcell.starbucks.starbucks.business.abstracts;

import turkcell.starbucks.starbucks.business.dto.requests.creates.CreateEDevletRequest;
import turkcell.starbucks.starbucks.business.dto.requests.updates.UpdateEDevletRequest;
import turkcell.starbucks.starbucks.business.dto.responses.creates.CreateEDevletResponse;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetAllEDevletResponse;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetEDevletResponse;
import turkcell.starbucks.starbucks.business.dto.responses.updates.UpdateEDevletResponse;

import java.util.List;

public interface EDevletService {
    List<GetAllEDevletResponse> getAll();
    GetEDevletResponse getById(int id);

    CreateEDevletResponse add(CreateEDevletRequest request);
    UpdateEDevletResponse update(int id, UpdateEDevletRequest request);
    void delete(int id);
}
