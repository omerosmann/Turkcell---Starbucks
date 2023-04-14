package turkcell.starbucks.starbucks.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import turkcell.starbucks.starbucks.business.abstracts.EDevletService;
import turkcell.starbucks.starbucks.business.dto.requests.creates.CreateEDevletRequest;
import turkcell.starbucks.starbucks.business.dto.requests.updates.UpdateEDevletRequest;
import turkcell.starbucks.starbucks.business.dto.responses.creates.CreateCustomerResponse;
import turkcell.starbucks.starbucks.business.dto.responses.creates.CreateEDevletResponse;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetAllCustomersResponse;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetAllEDevletResponse;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetCustomerResponse;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetEDevletResponse;
import turkcell.starbucks.starbucks.business.dto.responses.updates.UpdateCustomerResponse;
import turkcell.starbucks.starbucks.business.dto.responses.updates.UpdateEDevletResponse;
import turkcell.starbucks.starbucks.entities.Customer;
import turkcell.starbucks.starbucks.entities.EDevlet;
import turkcell.starbucks.starbucks.repository.EDevletRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EdevletManager implements EDevletService {
    private final EDevletRepository eDevletRepository;
    private ModelMapper mapper;

    @Override
    public List<GetAllEDevletResponse> getAll() {
        List<EDevlet> eDevlets = eDevletRepository.findAll();

        List<GetAllEDevletResponse> responses = eDevlets
                .stream()
                .map(eDevlet -> mapper.map(eDevlet, GetAllEDevletResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetEDevletResponse getById(int id) {
        EDevlet eDevlet = eDevletRepository.findById(id).orElseThrow();

        GetEDevletResponse response = mapper.map(eDevlet, GetEDevletResponse.class);

        return response;
    }

    @Override
    public CreateEDevletResponse add(CreateEDevletRequest request) {


        EDevlet eDevlet = mapper.map(request, EDevlet.class);

        eDevlet.setId(0);
        addEDevletControl(eDevlet);
        eDevletRepository.save(eDevlet);

        CreateEDevletResponse response = mapper.map(eDevlet, CreateEDevletResponse.class);

        return response;
    }

    @Override
    public UpdateEDevletResponse update(int id, UpdateEDevletRequest request) {


        EDevlet eDevlet = mapper.map(request, EDevlet.class);

        eDevlet.setId(id);
        eDevletRepository.save(eDevlet);

        UpdateEDevletResponse response = mapper.map(eDevlet, UpdateEDevletResponse.class);

        return response;
    }

    @Override
    public void delete(int id) { eDevletRepository.deleteById(id); }

    private void addEDevletControl(EDevlet eDevlet){
        List<EDevlet> eDevlets = eDevletRepository.findAll();

        for (EDevlet eDevlet1 : eDevlets) {
            if(eDevlet1.getIdentificationNumber().equals(eDevlet.getIdentificationNumber()))
                throw new RuntimeException("Citizen registration is available.");
        }
    }
}
