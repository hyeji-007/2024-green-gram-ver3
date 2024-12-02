package com.green.greengramver2.feed.comment;

import com.green.greengramver2.feed.comment.model.FeedCommentDelReq;
import com.green.greengramver2.feed.comment.model.FeedCommentPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper mapper;

    @Transactional
    public long postCommentUp(FeedCommentPostReq p) {
        int result = mapper.insFeedComment(p);
        return p.getFeedCommentId();
    }

    public long deleteFeedComment(FeedCommentDelReq p) {
        int result = mapper.delFeedComment(p);
        return p.getFeedCommentId();
    }

}
