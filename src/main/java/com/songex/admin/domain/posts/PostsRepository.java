package com.songex.admin.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") // SpringDataJPA에서 제공하지 않는 메소드는 직접 쿼리 작성해도 가능 @Query를 이용해서, 실제로는 JPA로도 가능 하긴함
    // 큰 규모의 프로젝트에서는 데이터 조회의 경우 querydsl(IDE에서 오타 검출 가능해 추천), jooq, MyBatis 같은 프레임워크를 사용하고 등록/수정/삭제 등은 SpringDataJPA를 통해 진행하는 경우가 많음
    List<Posts> findAllDesc();
}
