package com.mohaeng.backend.member.dto.response;

import com.mohaeng.backend.place.domain.PlaceBookmark;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MyPagePlaceBookMarkDto {
    private Long bookMarkId;
    private Long placeId;
    private String contendId;
    private String placeName;
    private double rating;
    private String address;
    private String content;
    private String imgUrl;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static MyPagePlaceBookMarkDto of (PlaceBookmark m) {
        return new MyPagePlaceBookMarkDto(
                m.getId(),
                m.getPlace().getId(),
                m.getPlace().getContentId(),
                m.getPlace().getName(),
                m.getPlace().getRating(),
                m.getPlace().getAddress(),
                m.getPlace().getOverview(),
                m.getPlace().getFirstImage(),
                m.getCreatedDate(),
                m.getModifiedDate()
        );
    }
}
