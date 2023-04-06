package com.mohaeng.backend.place.controller;

import com.mohaeng.backend.common.BaseResponse;
import com.mohaeng.backend.member.jwt.TokenGenerator;
import com.mohaeng.backend.place.domain.Place;
import com.mohaeng.backend.place.dto.request.CreateReviewRequest;
import com.mohaeng.backend.place.dto.request.UpdateReviewRequest;
import com.mohaeng.backend.place.dto.response.FindAllReviewResponse;
import com.mohaeng.backend.place.exception.PlaceNotFoundException;
import com.mohaeng.backend.place.repository.PlaceRepository;
import com.mohaeng.backend.place.repository.ReviewRepository;
import com.mohaeng.backend.place.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final TokenGenerator tokenGenerator;
    private final ReviewRepository reviewRepository;
    private final PlaceRepository placeRepository;

    @GetMapping("/review/{placeId}")
    public ResponseEntity getPlaceReview(@PathVariable Long placeId) {
        List<FindAllReviewResponse> data = reviewService.getAllReview(placeId);
        Map<String, Object> summary = reviewService.getReviewSummary(placeId);
        Map<String, Object> result = new HashMap<>();
        result.put("reviews", data);
        result.putAll(summary);
        return ResponseEntity.ok(BaseResponse.success("ok", result));
    }

    @PostMapping("/review/{placeId}")
    public ResponseEntity addPlaceReview(@PathVariable Long placeId, HttpServletRequest request,
                                         @RequestPart(value = "review") @Valid CreateReviewRequest createReviewRequest,
                                         @RequestPart(value = "multipartFile", required = false) MultipartFile multipartFile) {
        String email = getEmail(request);
        reviewService.createReview(email, placeId, createReviewRequest, multipartFile);
        return ResponseEntity.ok(BaseResponse.success("ok", ""));
    }

    private String getEmail(HttpServletRequest httpServletRequest) {
        return tokenGenerator.parseEmailFromToken(httpServletRequest.getHeader("Access-Token"));
    }

    @PutMapping(value = "/review/{placeId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<BaseResponse<String>> updatePlaceReview(@PathVariable Long placeId, HttpServletRequest request,
                                                                  @RequestPart(value = "review") @Valid UpdateReviewRequest updateReviewRequest,
                                                                  @RequestPart(value = "multipartFile", required = false) MultipartFile multipartFile){
        String email = getEmail(request);
        reviewService.updateReview(email, placeId, updateReviewRequest,multipartFile);
        return ResponseEntity.ok(BaseResponse.success("ok", ""));
    }

//    @DeleteMapping("/review/{placeId}")
    @DeleteMapping(value = "/review/{placeId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<BaseResponse<String>> deletePlaceReview(@PathVariable Long placeId, HttpServletRequest request) {
        String email = getEmail(request);
        reviewService.deleteReview(email, placeId);
        return ResponseEntity.ok(BaseResponse.success("ok", ""));
    }

}
