package com.songex.admin.service.posts;

import com.songex.admin.domain.posts.Posts;
import com.songex.admin.domain.posts.PostsRepository;
import com.songex.admin.web.dto.PostsResponseDto;
import com.songex.admin.web.dto.PostsSaveRequestDto;
import com.songex.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다 ID = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
                return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다 ID = " + id));
                return  new PostsResponseDto(entity);
    }
}
