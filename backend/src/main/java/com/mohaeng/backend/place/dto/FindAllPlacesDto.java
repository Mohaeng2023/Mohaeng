package com.mohaeng.backend.place.dto;

import com.mohaeng.backend.place.domain.Place;
import com.mohaeng.backend.place.service.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FindAllPlacesDto {

    private static PlaceService placeService;
    private Long placeId;
    private String name;
    private String areaCode;
    private String firstImage;
    private String contentId;
    private Boolean isBookmarked;
    private double averageRating;
    private long review;

    public static FindAllPlacesDto from(Place place, Boolean isBookmarked, double averageRating, long review){
        String firstImage = place.getFirstImage();
        if (firstImage == null || firstImage.isEmpty()) {
            firstImage = placeService.getFirstImage();
        }
        return new FindAllPlacesDto(place.getId(), place.getName(), place.getAreaCode(), firstImage, place.getContentId(), isBookmarked, averageRating, review);
    }
}

