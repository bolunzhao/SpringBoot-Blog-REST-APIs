package com.blogproject.springbootblogrestapi.service;

import com.blogproject.springbootblogrestapi.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId (long postId);

    CommentDto getCommentById(Long postId,Long commentId);

    CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest);

    void deleteComment(Long postId, Long commentId);

    boolean isCommentOwner(Long commentId, String name);
}
