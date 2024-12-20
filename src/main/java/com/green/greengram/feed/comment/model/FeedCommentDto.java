package com.green.greengram.feed.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

//Data Transfer Object: 컨트롤러, 서비스, 또는 클라이언트로 데이터를 전달할 때
// DTO가 중간 매개체 역할을 함
@Getter
@Setter
public class FeedCommentDto {
    private long feedCommentId;
    private String comment;
    private long writerUserId;
    private String writerNm;
    private String writerPic;
    @JsonIgnore
    private long feedId;
}
