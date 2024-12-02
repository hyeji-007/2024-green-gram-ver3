package com.green.greengramver2.feed.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedCommentPostReq {
    @JsonIgnore
    private long feedCommentId;

    @Schema(description = "피드 아이디", example = "mic"
            , requiredMode = Schema.RequiredMode.REQUIRED)
    private long feedId;
    @Schema(description = "유저 아이디", example = "mic2"
            , requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;
    @Schema(description = "내용", example = "하하하"
            , requiredMode = Schema.RequiredMode.REQUIRED)
    private String comment;
}
