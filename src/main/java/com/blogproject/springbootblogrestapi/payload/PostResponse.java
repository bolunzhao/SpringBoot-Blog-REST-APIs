package com.blogproject.springbootblogrestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Pagination Model Information"
)
public class PostResponse {
    @Schema(
            description = "Posts within one page"
    )
    private List<PostDto> content;
    @Schema(
            description = "Page Number"
    )
    private int pageNo;
    @Schema(
            description = "Post Number within one page"
    )
    private int pageSize;
    @Schema(
            description = "Total Post Number"
    )
    private long totalElements;
    @Schema(
            description = "Total Page Number"
    )
    private int totalPages;
    @Schema(
            description = "Last Page or Not"
    )
    private boolean last;
}
