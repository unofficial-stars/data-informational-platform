package com.unoffstars.dip.datacollection.model.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class RequestAccount {
    private String username;
    private String email;
    private String password;
    private List<RequestCourse> courses;
}
