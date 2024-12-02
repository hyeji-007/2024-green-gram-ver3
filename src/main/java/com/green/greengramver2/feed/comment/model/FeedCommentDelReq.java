package com.green.greengramver2.feed.comment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedCommentDelReq {
    private long feedCommentId;
    private long feedId;
    private long userId;
}
