package com.songex.admin.web.dto;

import com.songex.admin.domain.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long memberNumber;
    private String id;
    private String password;
    private LocalDateTime createDate; // 자동추가 기능 찾아보기
    private LocalDateTime modifiedDate;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .memberNumber(memberNumber)
                .id(id)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long memberNumber, String id, String password) {
        this.memberNumber = memberNumber;
        this.id = id;
        this.password = password;
    }
}
