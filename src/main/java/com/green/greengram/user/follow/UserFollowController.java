package com.green.greengram.user.follow;

import com.green.greengram.common.model.ResultResponse;
import com.green.greengram.user.follow.model.UserFollowDelReq;
import com.green.greengram.user.follow.model.UserFollowReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user/follow")
public class UserFollowController {
    private final UserFollowService service;

    //팔로우 신청
    // @requestBody를 쓴다는 것은 요청을 보내는 자가 body에 json형태의 데이터를 담아서 보낸다는 뜻
    @PostMapping
    public ResultResponse<Integer> postUserFollow(@RequestBody UserFollowReq p) {
        return null;
    }

    //팔로우 취소
    // 요청을 보내는 자가 데이터를 어떻게 보내나?
    @DeleteMapping
    public ResultResponse<Integer> deleteUserFollow(@ParameterObject @ModelAttribute UserFollowDelReq p) {
        return null;
    }
}
