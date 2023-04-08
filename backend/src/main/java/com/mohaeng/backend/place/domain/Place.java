package com.mohaeng.backend.place.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mohaeng.backend.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Table;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Builder
@Getter
@Table(appliesTo = "place")
@RequiredArgsConstructor
@ToString
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test-sequence-generator")
    @GenericGenerator(
            name = "test-sequence-generator",
            strategy = "sequence",
            parameters = {
                    @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = SequenceStyleGenerator.DEF_VALUE_COLUMN),
                    @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
                    @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "100"),
                    @Parameter(name = AvailableSettings.PREFERRED_POOLED_OPTIMIZER, value = "pooled-lo")
            }
    )
    @Column(name = "place_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String name;
    private String address;
    private String areaCode;
    private String sigunguCode;
    private String firstImage;
    private String firstImage2;
    private String mapX;
    private String mapY;
    private String contentId;
    private String overview;
    private double rating;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "place")
    private List<Review> reviewList = new ArrayList<>();

    public Place(String name, String address, String areaCode, String sigunguCode, String contentId, String firstImage, String firstImage2, String mapX, String mapY) {
        this.name = name;
        this.address = address;
        this.areaCode = areaCode;
        this.sigunguCode = sigunguCode;
        this.contentId = contentId;
        this.firstImage = firstImage;
        this.firstImage2 = firstImage2;
        this.mapX = mapX;
        this.mapY = mapY;
    }

    public Place(Long id, String name, String address, String areaCode, String firstImage, String firstImage2, String mapX, String mapY, String sigunguCode, String contentId, String overview, double rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.areaCode = areaCode;
        this.firstImage = firstImage;
        this.firstImage2 = firstImage2;
        this.mapX = mapX;
        this.mapY = mapY;
        this.sigunguCode = sigunguCode;
        this.contentId = contentId;
        this.overview = overview;
        this.rating = rating;
    }

    public Place(Long id, String name, String address, String areaCode, String sigunguCode, String firstImage, String firstImage2, String mapX, String mapY, String contentId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.areaCode = areaCode;
        this.sigunguCode = sigunguCode;
        this.firstImage = firstImage;
        this.firstImage2 = firstImage2;
        this.mapX = mapX;
        this.mapY = mapY;
        this.contentId = contentId;
    }

    public Place(String name, String firstImage, String contentId) {
        this.name = name;
        this.firstImage = firstImage;
        this.contentId = contentId;
    }

    public Place(Long id, String name, String address, String areaCode, String sigunguCode, String firstImage, String firstImage2, String mapX, String mapY, String contentId, String overview, double rating, Member member) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.areaCode = areaCode;
        this.sigunguCode = sigunguCode;
        this.firstImage = firstImage;
        this.firstImage2 = firstImage2;
        this.mapX = mapX;
        this.mapY = mapY;
        this.contentId = contentId;
        this.overview = overview;
        this.rating = rating;
        this.member = member;
    }

    public void addReview(Review review) {
        this.getReviewList().add(review);
    }
}
