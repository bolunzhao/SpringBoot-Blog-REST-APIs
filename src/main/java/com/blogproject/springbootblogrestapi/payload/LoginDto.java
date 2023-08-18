package com.blogproject.springbootblogrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "LoginDto Model Information"
)
public class LoginDto {
    @Schema(
            description = "Login Identification"
    )
    private String usernameOrEmail;
    @Schema(
            description = "Login Password"
    )
    private String password;
}
