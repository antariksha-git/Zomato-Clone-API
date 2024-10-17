package org.ex.zomato.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.ex.zomato.enums.DietType;

import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+91[0-9]{10}$", message = "Phone number must be in the format +91 followed by 10 digits")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email must be a valid format")
    private String email;

    @NotEmpty(message = "At least one diet type is required")
    private List<DietType> dietTypes;
}
