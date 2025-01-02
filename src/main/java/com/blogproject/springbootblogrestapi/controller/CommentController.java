package com.blogproject.springbootblogrestapi.controller;

import com.blogproject.springbootblogrestapi.payload.CommentDto;
import com.blogproject.springbootblogrestapi.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(
        name = "CRUD REST APIs for Comment Resource"
)
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(
            summary = "Create Comment REST API",
            description = "Create Comment REST API is used to save comment into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/posts/{postId}/comments")
    @PreAuthorize("isAuthenticated()") // Ensures that only authenticated users can create comments
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Comments By Post ID REST API",
            description = "Get Comments By Post ID REST API is used to get comments " +
                    "within single post from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @Operation(
            summary = "Get Comment By ID REST API",
            description = "Get Comment By ID REST API is used to get single comment from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") Long postId,
                                                     @PathVariable(value = "commentId") Long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Comment REST API",
            description = "Update Comment REST API is used to update a particular comment in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("/posts/{postId}/comments/{commentId}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") Long postId,
                                                    @PathVariable(value = "commentId") Long commentId,
                                                    @Valid @RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Comment REST API",
            description = "Delete Comment REST API is used to delete a particular comment from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(value = "commentId") Long commentId){
        commentService.deleteComment(postId,commentId);

        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
