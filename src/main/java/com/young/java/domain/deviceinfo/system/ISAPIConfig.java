package com.young.java.domain.deviceinfo.system;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2016/1/2.
 */
@XStreamAlias("isapi")
public class ISAPIConfig {
    private String isapiPrefix;
    private String isapiUser;
    private String isapiPassword;

    public String getIsapiPrefix() {
        return isapiPrefix;
    }

    public void setIsapiPrefix(String isapiPrefix) {
        this.isapiPrefix = isapiPrefix;
    }

    public String getIsapiUser() {
        return isapiUser;
    }

    public void setIsapiUser(String isapiUser) {
        this.isapiUser = isapiUser;
    }

    public String getIsapiPassword() {
        return isapiPassword;
    }

    public void setIsapiPassword(String isapiPassword) {
        this.isapiPassword = isapiPassword;
    }
}
