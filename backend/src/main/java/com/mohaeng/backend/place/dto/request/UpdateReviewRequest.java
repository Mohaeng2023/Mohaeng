package com.mohaeng.backend.place.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateReviewRequest {

//    private String title;
    private String content;
    private double rating;
    private MultipartFile multipartFile;

}
