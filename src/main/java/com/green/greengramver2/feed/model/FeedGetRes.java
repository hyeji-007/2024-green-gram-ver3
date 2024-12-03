package com.green.greengramver2.feed.model;

import com.green.greengramver2.feed.comment.model.FeedCommentGetRes;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedGetRes {
    private long feedId;
    private String contents;
    private String location;
    private String createdAt;
    private long writerUserId;
    private String writerNm;
    private String writerPic;
    private int isLike;

    private List<String> pics;
    private FeedCommentGetRes comment; //피드 당 응답할 때 사용하는 객체 >> 댓글 정보를 담음
    // comment에는 FeedCommentGetRes 객체의 주소값만 담아야 함.
}

