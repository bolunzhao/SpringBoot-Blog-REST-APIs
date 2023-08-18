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
        description = "Register Model Information"
)
public class RegisterDto {
    @Schema(
            description = "User's Real Name"
    )
    private String name;
    @Schema(
            description = "User Name"
    )
    private String username;
    @Schema(
            description = "User's Email"
    )
    private String email;
    @Schema(
            description = "User's Password"
    )
    private String password;
}
