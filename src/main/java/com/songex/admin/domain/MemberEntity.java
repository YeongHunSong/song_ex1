package com.songex.admin.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNumber;

    @Column(length = 14, nullable = false)
    private String id;

    @Column(length = 14, nullable = false)
    private String password;

    @Builder
    public MemberEntity(Long memberNumber, String id, String password) {
        this.memberNumber=memberNumber;
        this.id=id;
        this.password=password;
    }
}
