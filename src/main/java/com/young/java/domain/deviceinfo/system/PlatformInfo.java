package com.young.java.domain.deviceinfo.system;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by Administrator on 2016/1/2.
 */
@XStreamAlias("platform")
public class PlatformInfo {

    @XStreamImplicit(itemFieldName = "pushUrl")
    private List<String> pushUrl;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    private String contentType;


    public List<String> getPushUrl() {
        return pushUrl;
    }

    public void setPushUrl(List<String> pushUrl) {
        this.pushUrl = pushUrl;
    }
}
