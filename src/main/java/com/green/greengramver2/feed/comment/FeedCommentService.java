package com.green.greengramver2.feed.comment;

import com.green.greengramver2.feed.comment.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper mapper;

    public long postCommentUp(FeedCommentPostReq p) {
        int result = mapper.insFeedComment(p);
        return p.getFeedCommentId();
    }

    public FeedCommentGetRes getFeedComment(FeedCommentGetReq p) {
        FeedCommentGetRes res = new FeedCommentGetRes();
        if(p.getPage() < 2) {
            res.setCommentList(new ArrayList<>()); // null 대신 빈값이라도 보내는 것
            return res;
        }

        List<FeedCommentDto> commentList = mapper.selFeedCommentList(p);
        res.setCommentList(commentList);
        res.setMoreComment(commentList.size() == p.getSize());

        if(res.isMoreComment()) {
            commentList.remove(commentList.size() - 1);
        }
        return res;

    }

    public long deleteFeedComment(FeedCommentDelReq p) {
        int result = mapper.delFeedComment(p);
        return p.getFeedCommentId();
    }

}
