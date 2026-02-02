package com.example.tandapp.domain.models;

import java.util.UUID;

public class MemberGroup {
    private final UUID memberId;
    private final Long moneyWhichOwned = 0L;

    public MemberGroup(UUID memberId, Long moneyWhichOwned) {
        this.memberId = memberId;
    }

    public boolean memberOwnedMoney(){
        return moneyWhichOwned > 0L;
    }

    public UUID getMemberId() {
        return memberId;
    }

}
