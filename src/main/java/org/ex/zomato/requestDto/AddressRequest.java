package org.ex.zomato.requestDto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
    @NotNull(message = "Address Line 1 cannot be null")
    @NotBlank(message = "Address Line 1 is mandatory")
    private String addressLine1;

    private String addressLine2;

    private String landmark;

    @NotNull(message = "Area cannot be null")
    @NotBlank(message = "Area is mandatory")
    private String area;

    @NotNull(message = "City cannot be null")
    @NotBlank(message = "City is mandatory")
    private String city;

    @NotNull(message = "State cannot be null")
    @NotBlank(message = "State is mandatory")
    private String state;

    @NotNull(message = "Pin Code cannot be null")
    @NotBlank(message = "Pin Code is mandatory")
    @Pattern(regexp = "\\d{6}", message = "Pin Code must be exactly 6 digits")
    private String pinCode;

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90.0 and 90.0")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90.0 and 90.0")
    private double latitude;

    @DecimalMin(value = "-180.0", message = "Longitude must be between -180.0 and 180.0")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180.0 and 180.0")
    private double longitude;
}
