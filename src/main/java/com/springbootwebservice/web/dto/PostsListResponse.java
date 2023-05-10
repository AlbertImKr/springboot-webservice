package com.springbootwebservice.web.dto;

import com.springbootwebservice.domain.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponse {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedData;

    public PostsListResponse(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedData = entity.getModifiedDate();
    }
}
