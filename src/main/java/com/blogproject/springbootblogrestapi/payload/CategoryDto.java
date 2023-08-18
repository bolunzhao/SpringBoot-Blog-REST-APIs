package com.blogproject.springbootblogrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "CategoryDto Model Information"
)
public class CategoryDto {
    private Long id;
    @Schema(
            description = "Blog Category Title"
    )
    private String name;
    @Schema(
            description = "Blog Category Description"
    )
    private String description;
}
