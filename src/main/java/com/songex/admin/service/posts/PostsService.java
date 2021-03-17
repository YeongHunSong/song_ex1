package com.songex.admin.service.posts;

import com.songex.admin.domain.posts.Posts;
import com.songex.admin.domain.posts.PostsRepository;
import com.songex.admin.web.dto.PostsListResponseDto;
import com.songex.admin.web.dto.PostsResponseDto;
import com.songex.admin.web.dto.PostsSaveRequestDto;
import com.songex.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하되 조회 기능만 남겨두어 조회속도가 개선됨 (등록, 수정, 삭제 기능이 없는 서비스 메소드에서 추천)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
        // .map(PostsListResponseDto::new) = .map(posts -> new PostsListResponseDto(posts))
    }
    
    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 ID = " + id));
        postsRepository.delete(posts); //JAPRepository에서 delete 메소드를 지원하기 때문에 활용, 엔티티를 파라미터로 삭제할 수도 있고 deleteById 메소드를 이용하면 id로 삭제할 수도 있음, 존재하는 Posts인지 확인을 하기 위해 엔티티 조회 후 그대로 삭제
    }
}
