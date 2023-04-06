package com.mohaeng.backend.member.controller;

import com.mohaeng.backend.common.BaseResponse;
import com.mohaeng.backend.member.domain.Member;
import com.mohaeng.backend.member.dto.request.UserInfoChangeRequest;
import com.mohaeng.backend.member.dto.response.MyPageCourseBookMarkDto;
import com.mohaeng.backend.member.dto.response.MyPagePlaceBookMarkDto;
import com.mohaeng.backend.member.jwt.TokenGenerator;
import com.mohaeng.backend.member.service.MemberService;
import com.mohaeng.backend.member.service.MyPageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api")
@ResponseBody
@RequiredArgsConstructor
@Service
public class MyPageController {
    private final MemberService memberService;
    private final MyPageService myPageService;
    private final TokenGenerator tokenGenerator;

    @GetMapping("/myPage/course/bookMark")
    public ResponseEntity getAllBookMarkedCourse(HttpServletRequest request) {
        String email = findEmailFromHeader(request);
        List<MyPageCourseBookMarkDto> data = myPageService.findAllBookMarkCourse(email);
        return ResponseEntity.ok().body(BaseResponse.success("ok", data));
    }

    @GetMapping("/myPage/course/bookMark/{courseLikeId}")
    public ResponseEntity getOneBookMarkedCourse(@PathVariable Long courseLikeId, HttpServletRequest request) {
        String email = findEmailFromHeader(request);
        MyPageCourseBookMarkDto data = myPageService.findOneBookMarkedCourse(email, courseLikeId);
        return ResponseEntity.ok().body(BaseResponse.success("OK", data));
    }

    @PutMapping(value = "/myPage/{memberEmail}")
    public ResponseEntity changeMemberProfile(@PathVariable String memberEmail,
                                              @RequestPart(value = "nickName") UserInfoChangeRequest userInfoChangeRequest,
                                              @RequestPart(value = "multipartFile", required = false) MultipartFile multipartFile) throws IOException {
        Member findMember = memberService.findByEmail(memberEmail);
        memberService.changeProfile(findMember, userInfoChangeRequest, multipartFile);
        return ResponseEntity.ok().body(BaseResponse.success("ok", ""));
    }

    @DeleteMapping("/user/drop")
    public ResponseEntity userDropController(HttpServletRequest request) {
        String userEmail = findEmailFromHeader(request);
        Member findMember = memberService.findByEmail(userEmail);
        myPageService.deleteMember(findMember);
        return ResponseEntity.ok().body(BaseResponse.success("ok", ""));
    }

    @GetMapping("/myPage/place/bookMark")
    public ResponseEntity getAllBookMarkedPlace(HttpServletRequest request) {
        String email = findEmailFromHeader(request);
        List<MyPagePlaceBookMarkDto> data = myPageService.findAllBookMarkedPlace(email);
        return ResponseEntity.ok().body(BaseResponse.success("ok", data));
    }

    @GetMapping("/myPage/place/bookMark/{placeBookMarkId}")
    public ResponseEntity getAllBookMarkedPlace(@PathVariable Long placeBookMarkId, HttpServletRequest request) {
        String email = findEmailFromHeader(request);
        MyPagePlaceBookMarkDto data = myPageService.findOneBookMarkedPlace(email, placeBookMarkId);
        return ResponseEntity.ok().body(BaseResponse.success("ok", data));
    }

    private String findEmailFromHeader(HttpServletRequest request) {
        return tokenGenerator.parseEmailFromToken(request.getHeader("Access-Token"));
    }

    /**
     * Amazon S3에 파일 업로드
     * @return 성공 시 200 Success와 함께 업로드 된 파일의 파일명 리스트 반환
     */
//    @PutMapping(value = "/myPage2/{memberEmail}")
//    public ResponseEntity changeMemberProfile2(@PathVariable String memberEmail,
//                                               @RequestPart(value = "nickName") UserInfoChangeRequest req,
//                                               @RequestPart(value = "multipartFiles", required = false) List<MultipartFile> multipartFiles)throws IOException{
//        Member findMember = memberService.findByEmail(memberEmail);
//        List<String> strings = memberService.changeProfile(findMember,req, multipartFiles);
//        return ResponseEntity.ok().body(BaseResponse.success("ok", strings));
//    }
}
