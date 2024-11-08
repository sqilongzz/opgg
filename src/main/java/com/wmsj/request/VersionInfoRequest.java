package com.wmsj.request;

import lombok.Data;

@Data
public class VersionInfoRequest {
    private String version;
    private String position;
    private String rankLevel;
}
