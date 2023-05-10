package com.springbootwebservice.service.posts;

import com.springbootwebservice.domain.post.Post;
import com.springbootwebservice.domain.post.PostRepository;
import com.springbootwebservice.web.dto.PostResponse;
import com.springbootwebservice.web.dto.PostSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequest requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostSaveRequest requestDto){
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostResponse findById(Long id){
        Post entity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostResponse(entity);
    }

}
