package com.mohaeng.backend.place.dto;

import com.mohaeng.backend.place.domain.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PlaceSearchDto {
    private Long placeId;
    private String name;
    private String contentId;
    private String firstImage;
    private Boolean isBookmarked;
    private double averageRating;
    private long reviewTotalElements;

    public static PlaceSearchDto from(Place place, Boolean isBookmarked, double averageRating, long reviewTotalElements){
        return new PlaceSearchDto(place.getId(), place.getName(),
                place.getContentId(), place.getFirstImage(), isBookmarked, averageRating, reviewTotalElements);
    }
}
