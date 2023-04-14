package turkcell.starbucks.starbucks.business.dto.responses.updates;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerResponse {
    private int id;
    private String name;
    private String lastName;
    private LocalDate ofDateBirth;
    private String identificationNumber;
}
