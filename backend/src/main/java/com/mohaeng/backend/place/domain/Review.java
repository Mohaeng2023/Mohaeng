package com.mohaeng.backend.place.domain;


import com.mohaeng.backend.common.BaseTimeEntity;
import com.mohaeng.backend.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLACE_ID")
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

//    private String title;
    private String content;
    private int likeCount;
    private double rating;
    private String imgUrl;

    public Review(//String title,
                  String content, double rating) {
//        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    public void update(//String title,
                       String content, double rating, MultipartFile multipartFile) {
//        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    public Review(Long id, Member member, String content, double rating) {
        this.id = id;
        this.member = member;
        this.content = content;
        this.rating = rating;
    }

    public Review(//String title,
                  String content, double rating, Member member) {
//        this.title = title;
        this.content = content;
        this.rating = rating;
        this.member = member;
    }
}
