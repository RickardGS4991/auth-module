package com.example.tandapp.domain.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TandaGroup {
    private UUID groupId = null;
    private final UUID chiefId;
    private final String groupName;
    private String description;
    private final LocalDate createdAt;
    private final LocalDate paymentDate;
    private final List<LocalDate> paymentDates;
    private final List<MemberGroup> members;
    private final Long contributionAmount;

    public TandaGroup(UUID chiefId, String groupName, String description, LocalDate createdAt, LocalDate paymentDate, List<LocalDate> paymentDates, List<MemberGroup> members, Long contributionAmount) {
        if(chiefId == null) throw new IllegalArgumentException("Chief Id cannot be null or blank");
        if(groupName == null || groupName.isBlank()) throw new IllegalArgumentException("Group Name cannot be null or blank");
        if(description == null || description.isBlank()) throw new IllegalArgumentException("Description cannot be null or blank");
        if(createdAt == null) throw new IllegalArgumentException("Created At cannot be null or blank");
        if(paymentDate == null) throw new IllegalArgumentException("Payment Date cannot be null or blank");
        if(paymentDates == null) throw new IllegalArgumentException("Payment Dates cannot be null or blank");
        if(members == null) throw new IllegalArgumentException("Members cannot be null or blank");
        if(contributionAmount == null) throw new IllegalArgumentException("Contribution Amount cannot be null or blank");
        if(contributionAmount < 100) throw new IllegalArgumentException("Contribution Amount cannot be minus 100");


        validateDuplicateDates(paymentDates);
        validateDuplicateMembers(members);

        this.chiefId = chiefId;
        this.groupName = groupName;
        this.description = description;
        this.createdAt = createdAt;
        this.paymentDate = paymentDate;
        this.paymentDates = List.copyOf(paymentDates);
        this.members = List.copyOf(members);
        this.contributionAmount = contributionAmount;
    }

    private void validateDuplicateDates(List<LocalDate> dates){
        Set<LocalDate> datesSet = new HashSet<>();

        for(LocalDate date: dates){
            if(!datesSet.add(date)) throw new IllegalArgumentException("Duplicate date " + date);
        }
    }

    private void validateDuplicateMembers(List<MemberGroup> members){
        Set<UUID> memberIdSet = new HashSet<>();

        for(MemberGroup member: members){
            if (!memberIdSet.add(member.getMemberId())) {
                throw new IllegalArgumentException(
                        "Duplicate member id " + member.getMemberId()
                );
            }
        }
    }

    public List<MemberGroup> getMembers() {
        return members;
    }

    public UUID getChiefId() {
        return chiefId;
    }

    public List<LocalDate> getPaymentDates() {
        return paymentDates;
    }

    public Long getRewardAmount() {
        return contributionAmount*members.size();
    }

    public String getDescription() {
        return description;
    }

    public void changeDescription(String description) {
        this.description = description;
    }
}
