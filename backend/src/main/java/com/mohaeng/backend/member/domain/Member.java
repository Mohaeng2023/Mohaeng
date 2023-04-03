package com.mohaeng.backend.member.domain;

import com.mohaeng.backend.common.BaseTimeEntity;
import com.mohaeng.backend.course.domain.CourseBookmark;
import com.mohaeng.backend.place.domain.PlaceBookmark;
import com.mohaeng.backend.place.domain.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "deleted_date IS NULL")
@SQLDelete(sql = "UPDATE member SET deleted_date = CURRENT_TIMESTAMP WHERE member_id = ?")
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String originName;
    private String imageURL="";
    private String imageName="";

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isActive;
    private int stopCount;

    private String oauthAccessToken;

    private Long kakaoId;

    @OneToMany(mappedBy = "member")
    private List<CourseBookmark> courseBookMarkList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<PlaceBookmark> placeBookmarkList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Review> reviewList;

    @Builder
    public Member(String name, String email, Role role, String nickName) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.nickName = nickName;
    }

    // OAuth 서버에서 사용자의 정보가 변경될 수 있기때문
    public Member update(String name) {
        this.name = name;
        return this;
    }

    public void changeNickName(String nickName) {
        this.nickName = nickName;
    }

    public void addCourseBookMark(CourseBookmark courseBookMark) {
        this.courseBookMarkList.add(courseBookMark);
    }

    public void removeCourseBookMark(CourseBookmark courseBookmark){
        this.courseBookMarkList.remove(courseBookmark);
    }

    public void setOauthAccessToken(String oauthAccessToken) {
        this.oauthAccessToken = oauthAccessToken;
    }

    public void changeImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void changeImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setKakaoId(Long kakaoId) {
        this.kakaoId = kakaoId;
    }


    public void addPlaceBookmark(PlaceBookmark placeBookmark) {
        this.placeBookmarkList.add(placeBookmark);
    }

    public void removePlaceBookmark(PlaceBookmark placeBookmark){
        this.placeBookmarkList.remove(placeBookmark);
    }
}

