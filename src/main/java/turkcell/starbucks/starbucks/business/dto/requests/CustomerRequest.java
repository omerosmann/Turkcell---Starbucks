package turkcell.starbucks.starbucks.business.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    @NotBlank (message = "Name cannot be empty.")
    @Length   (min = 3, message = "The Name must be at least 3 letters.")
    private String name;

    @NotBlank (message = "Last Name cannot be empty.")
    @Length   (min = 2, message = "Last Name must be at least 2 letters.")
    private String lastName;

    @NotNull(message = "Birth Date cannot be empty.")
    private LocalDate ofDateBirth;

    @NotBlank (message = "Identification Number cannot be empty.")
    @Length   (min = 11, max = 11, message = "The Identification Number must be 11 digits.")
    private String identificationNumber;
}