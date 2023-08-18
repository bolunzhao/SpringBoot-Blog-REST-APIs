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
        description = "JwtAuthResponse Model Information"
)
public class JwtAuthResponse {
    @Schema(
            description = "JWT Access Token Content"
    )
    private String accessToken;
    @Schema(
            description = "JWT Access Token Type"
    )
    private String tokenType="Bearer";
}
