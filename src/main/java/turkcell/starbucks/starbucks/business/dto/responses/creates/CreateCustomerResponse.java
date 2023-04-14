package turkcell.starbucks.starbucks.business.dto.responses.creates;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerResponse {
    private int id;
    private String name;
    private String lastName;
    private LocalDate ofDateBirth;
    private String identificationNumber;
}
