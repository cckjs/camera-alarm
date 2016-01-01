package com.young.java.domain.deviceinfo.system;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2016/1/2.
 */
@XStreamAlias("alarmCenter")
public class AlarmCenterInfo {
    private String httpNotificationUrl;
    private String httpNotificationId;
    private String httpNotificationIp;
    private String httpNotificationPort;

    public String getHttpNotificationUrl() {
        return httpNotificationUrl;
    }

    public void setHttpNotificationUrl(String httpNotificationUrl) {
        this.httpNotificationUrl = httpNotificationUrl;
    }

    public String getHttpNotificationId() {
        return httpNotificationId;
    }

    public void setHttpNotificationId(String httpNotificationId) {
        this.httpNotificationId = httpNotificationId;
    }

    public String getHttpNotificationIp() {
        return httpNotificationIp;
    }

    public void setHttpNotificationIp(String httpNotificationIp) {
        this.httpNotificationIp = httpNotificationIp;
    }

    public String getHttpNotificationPort() {
        return httpNotificationPort;
    }

    public void setHttpNotificationPort(String httpNotificationPort) {
        this.httpNotificationPort = httpNotificationPort;
    }
}
