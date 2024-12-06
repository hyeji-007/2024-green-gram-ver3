package com.green.greengram.user.model;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserInfoGetReq {
    private long signedUserId;
    private long profileUserId;

    public UserInfoGetReq(long signedUserId, long profileUserId){
        this.signedUserId = signedUserId;
        this.profileUserId = profileUserId;
    }
}



