package turkcell.starbucks.starbucks.api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import turkcell.starbucks.starbucks.business.abstracts.EDevletService;
import turkcell.starbucks.starbucks.business.dto.requests.creates.CreateEDevletRequest;
import turkcell.starbucks.starbucks.business.dto.requests.updates.UpdateEDevletRequest;
import turkcell.starbucks.starbucks.business.dto.responses.creates.CreateEDevletResponse;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetAllEDevletResponse;
import turkcell.starbucks.starbucks.business.dto.responses.gets.GetEDevletResponse;
import turkcell.starbucks.starbucks.business.dto.responses.updates.UpdateEDevletResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping ("/api/edevlets")
public class EDevletsController {
    private final EDevletService service;

    @GetMapping
    public List<GetAllEDevletResponse> getall()
    { return service.getAll(); }

    @GetMapping ("/{id}")
    public GetEDevletResponse getById(@PathVariable int id)
    { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEDevletResponse add(@Valid @RequestBody CreateEDevletRequest request)
    { return service.add(request); }

    @PutMapping ("/{id}")
    public UpdateEDevletResponse update(@PathVariable int id, @Valid  @RequestBody UpdateEDevletRequest request)
    { return service.update(id, request); }

    @DeleteMapping ("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id)
    { service.delete(id); }
}
