package com.workspace.server.dto;

import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Data
public class UserMeetingsResponse {
    private Long id;
    private String title;
    private String color;
    private Instant timeOfStart;
    private Instant timeOfEnd;
    private String organizerName;
    private Set<MeetingUsersResponse> users;
    private String address;
    private String about;
    private byte maxPeople;


    public UserMeetingsResponse(Long id, String title, String color, Instant timeOfStart, Instant timeOfEnd,
                                String organizerName,
                                Set<MeetingUsersResponse> users, String address, String about, byte maxPeople) {
        this.id = id;
        this.title = title;
        this.color = color;
        this.timeOfStart = timeOfStart;
        this.timeOfEnd = timeOfEnd;
        this.organizerName = organizerName;
        this.users = users;
        this.address = address;
        this.about = about;
        this.maxPeople = maxPeople;
    }
}
