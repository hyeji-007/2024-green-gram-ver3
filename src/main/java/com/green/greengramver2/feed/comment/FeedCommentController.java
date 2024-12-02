package com.green.greengramver2.feed.comment;

import com.green.greengramver2.common.model.ResultResponse;
import com.green.greengramver2.feed.comment.model.FeedCommentDelReq;
import com.green.greengramver2.feed.comment.model.FeedCommentPostReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("feed/comment")
public class FeedCommentController {
    private final FeedCommentService service;

    @PostMapping
    @Operation(summary = "댓글 등록")
    public ResultResponse<Long> postFeedComment (@RequestBody FeedCommentPostReq p) {
        long result = service.postCommentUp(p);
        return ResultResponse.<Long>builder()
                .resultMessage("댓글 등록 완료")
                .resultData(result)
                .build();
    }


    @DeleteMapping
    @Operation(summary = "댓글 삭제")
    public ResultResponse<Long> deleteFeedComment (@ParameterObject @ModelAttribute FeedCommentDelReq p) {
        long result = service.deleteFeedComment(p);
        return ResultResponse.<Long>builder()
                .resultMessage("댓글 삭제 완료")
                .resultData(result)
                .build();
    }


}
