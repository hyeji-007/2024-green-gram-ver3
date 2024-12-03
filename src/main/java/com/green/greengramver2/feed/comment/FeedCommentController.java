package com.green.greengramver2.feed.comment;

import com.green.greengramver2.common.model.ResultResponse;
import com.green.greengramver2.feed.comment.model.FeedCommentDelReq;
import com.green.greengramver2.feed.comment.model.FeedCommentGetReq;
import com.green.greengramver2.feed.comment.model.FeedCommentGetRes;
import com.green.greengramver2.feed.comment.model.FeedCommentPostReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.impl.NoOpLog;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("feed/comment")
@Tag(name = "4. 피드 댓글", description = "피드 댓글 관리")
public class FeedCommentController {
    private final FeedCommentService service;

    @PostMapping
    @Operation(summary = "피드 댓글 등록", description = "")
    public ResultResponse<Long> postFeedComment (@RequestBody FeedCommentPostReq p) {
        long result = service.postCommentUp(p);
        return ResultResponse.<Long>builder()
                .resultMessage("댓글 등록 완료")
                .resultData(result)
                .build();
    }

    // 쿼리스트링
    @GetMapping
    @Operation(summary = "피드 댓글 리스트", description = "댓글 더보기 처리")
    public ResultResponse<FeedCommentGetRes> getFeedCommentList(@ParameterObject @ModelAttribute FeedCommentGetReq p) {
        log.info("FeedCommentController > getFeedComment > p: {}", p);
        FeedCommentGetRes res = service.getFeedComment(p);
        return ResultResponse.<FeedCommentGetRes>builder()
                .resultMessage(String.format("%d rows", res.getCommentList().size()))
                .resultData(res)
                .build();
    }

    @GetMapping("/ver2")
    @Operation(summary = "피드 댓글 리스트", description = "댓글 더보기 처리")
    public ResultResponse<FeedCommentGetRes> getFeedComment2(@Parameter(description = "피드 PK", example = "12") @RequestParam("feed_id") long feedId
            , @Parameter(description = "페이지", example = "2") @RequestParam int page
    ) {
        FeedCommentGetReq p = new FeedCommentGetReq(feedId, page);
        log.info("FeedCommentController > getFeedComment > p: {}", p);
        FeedCommentGetRes res = service.getFeedComment(p);
        return ResultResponse.<FeedCommentGetRes>builder()
                .resultMessage(String.format("%d rows", res.getCommentList().size()))
                .resultData(res)
                .build();
    }


    // 삭제 시 받아야 할 데이터 feedCommentId + 로그인한 사용자의 PK (feed_comment_id, signed_user_id)
    // FE - data 전달방식 : Query-String
    @DeleteMapping
    @Operation(summary = "댓글 삭제1")
    public ResultResponse<Long> deleteFeedComment (@ParameterObject @ModelAttribute FeedCommentDelReq p) {
        log.info("FeedCommentController > delFeedComment > p: {}" , p);
        long result = service.deleteFeedComment(p);
        return ResultResponse.<Long>builder()
                .resultMessage("댓글 삭제 완료")
                .resultData(result)
                .build();
    }



    /*
    @DeleteMapping
    @Operation(summary = "댓글 삭제2")
    public ResultResponse<Long> deleteFeedComment (@RequestParam("feed_comment_id") long feedCommentId,
                                                   @RequestParam("signed_user_id") long signedUserId) {
        FeedCommentDelReq p = new FeedCommentDelReq(0,0);
        p.setFeedCommentId(feedCommentId);
        p.setSignedUserId(signedUserId);
        log.info("delFeedComment {}", p.toString());
        long result = service.deleteFeedComment(p);
        return ResultResponse.<Long>builder()
                .resultMessage("댓글 삭제 완료")
                .resultData(result)
                .build();
    }
     */


}
