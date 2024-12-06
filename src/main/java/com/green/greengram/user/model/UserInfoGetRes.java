package com.green.greengram.user.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoGetRes {
    private long userId;
    private String pic;
    private String createdAt;
    private String nickName;
    private int follower;
    private int following;
    private int feedCnt;
    private int likeCnt;
    private int followState;

}
