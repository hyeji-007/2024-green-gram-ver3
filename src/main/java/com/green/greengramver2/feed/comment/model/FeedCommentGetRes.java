package com.green.greengramver2.feed.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengramver2.common.model.Paging;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedCommentGetRes  {
    private boolean moreComment;
    private List<FeedCommentDto> commentList; //댓글 3개 담김, 담기는 댓글은 3개 이하, 4개 > 하나 제거
    //List<FeedGetRes> getFeedList
}
