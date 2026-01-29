package com.example.tandapp.domain.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TandaGroup {
    private final UUID id;
    private final String groupName;
    private String description;
    private final LocalDate createdAt;
    private final List<LocalDate> payDays;
    private final List<MemberInTheGroup> members;
    private final Long contributionAmount;

    public TandaGroup(UUID id, String groupName, String description, LocalDate createdAt, List<LocalDate> payDays, List<MemberInTheGroup> members, Long contributionAmount) {
        if(id == null) throw new IllegalArgumentException("id cannot be null");
        if(groupName == null || groupName.isEmpty()) throw new IllegalArgumentException("This group must have a name");
        if(description == null || description.isEmpty()) throw new IllegalArgumentException("This group must have a description");
        if(members == null || members.isEmpty()) throw new IllegalArgumentException("This group must have a memberId");
        if(members.size() > 10) throw new IllegalArgumentException("Maximum quantity of member in a group is 10");
        if(contributionAmount <= 0) throw new IllegalArgumentException("This group must have a contribution");

        validateNoDuplicateMembers(members);
        avoidDuplicatePayDays(payDays);

        this.id = id;
        this.groupName = groupName;
        this.description = description;
        this.createdAt = createdAt;
        this.payDays = List.copyOf(payDays);
        this.members = List.copyOf(members);
        this.contributionAmount = contributionAmount;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public long rewardAmount() {
        return contributionAmount*members.size();
    }

    public UUID getId() {
        return id;
    }

    public Long getContributionAmount() {
        return contributionAmount;
    }

    private void avoidDuplicatePayDays(List<LocalDate> payDays){
        Set<LocalDate> setDays = new HashSet<>();

        for(LocalDate payDay : payDays){
            if(!setDays.add(payDay)){
                throw new IllegalArgumentException("Pay day already exists");
            }
        }
    }

    private void validateNoDuplicateMembers(List<MemberInTheGroup> members) {
        Set<UUID> uniqueMemberIds = new HashSet<>();

        for (MemberInTheGroup member : members) {
            if (!uniqueMemberIds.add(member.getMemberId())) {
                throw new IllegalArgumentException("Duplicate member in group: " + member.getMemberId());
            }
        }
    }

    public void changeDescription(String newDescription){
        if(newDescription == null || newDescription.isEmpty()) throw new IllegalArgumentException("New description cannot be null or empty");
        this.description = newDescription;
    }
}
