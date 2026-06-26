package app.model.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class UserLoginRequest {
    @Size(min = 6, message = "Username must be at least 6 characters long")
    private String username;
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
//    @NotNull(message = "Country is required")
    private String country;


}
