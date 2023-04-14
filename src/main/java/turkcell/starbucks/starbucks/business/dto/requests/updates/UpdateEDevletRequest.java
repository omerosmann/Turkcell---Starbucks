package turkcell.starbucks.starbucks.business.dto.requests.updates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEDevletRequest {
    private String name;
    private String lastName;
    private LocalDate ofDateBirth;
    private String identificationNumber;

}