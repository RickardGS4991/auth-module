package com.example.tandapp.domain.models;

import java.util.UUID;

public class MemberInTheGroup {
    private final UUID memberId;
    private final Integer turn;
    private Long owesMoneyInThisGroup = 0L;

    public MemberInTheGroup(UUID memberId, Integer turn){
        this.memberId = memberId;
        this.turn = turn;
    }

    public Boolean owesMoney(){
        return owesMoneyInThisGroup > 0.0;
    }

    public UUID getMemberId(){
        return memberId;
    }
}
