package com.blogproject.springbootblogrestapi.repository;

import com.blogproject.springbootblogrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategoryId(Long categoryId);

    @Query("SELECT p FROM Post p WHERE " +
            "p.title LIKE CONCAT('%',:query, '%')" +
            "Or p.content LIKE CONCAT('%', :query, '%')")
    List<Post> searchPosts(String query);
}
