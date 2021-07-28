package com.unoffstars.dip.datacollection.model.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class RequestDataCollection {

    private List<RequestAccount> data;
}
