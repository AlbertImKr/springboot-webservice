package com.springbootwebservice.domain.post;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @AfterEach
    public void cleanup() {
        postRepository.deleteAll();
    }

    @DisplayName("게시글 저장 불러오기")
    @Test
    void savePostAndGet() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Post.builder()
                .title(title)
                .content(content)
                .author("albertkr@gmail.com")
                .build());

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @DisplayName("BaseTimeEntity 등록")
    @Test
    void saveBaseTimeEntity() {
        //given
        LocalDateTime now = LocalDateTime.of(2023, 5, 10, 9, 52, 10);
        postRepository.save(Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Post> posts = postRepository.findAll();

        //then
        Post post = posts.get(0);

        System.out.println(">>>>>>>>> createDate=" + post.getCreatedDate() + ", modifiedData=" + post.getModifiedDate());

        assertThat(post.getCreatedDate()).isAfter(now);
        assertThat(post.getModifiedDate()).isAfter(now);
    }
}
