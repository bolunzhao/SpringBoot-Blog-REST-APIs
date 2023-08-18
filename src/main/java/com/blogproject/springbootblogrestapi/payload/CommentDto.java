package com.blogproject.springbootblogrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        description = "CommentDto Model Information"
)
public class CommentDto {
    private long id;

    @Schema(
            description = "Post Comment Author Name"
    )
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    // email field validation
    @Schema(
            description = "Post Comment Author Email"
    )
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    @Schema(
            description = "Post Comment Body"
    )
    @NotEmpty
    @Size(min = 10,message = "Comment should have at least 10 characters")
    private String body;
}
