package com.young.java.domain.deviceinfo.notification;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by Administrator on 2016/1/1.
 */
@XStreamAlias("HttpHostNotification")
public class HttpHostNotification {
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    private String id;
    private String url;
    private String protocolType;
    private String parameterFormatType;
    private String addressingFormatType;
    private String ipAddress;
    private String portNo;
    private String userName;
    private String password;
    private String httpAuthenticationMethod;
    @XStreamAsAttribute
    private String version;
    @XStreamAsAttribute
    private String xmlns;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getParameterFormatType() {
        return parameterFormatType;
    }

    public void setParameterFormatType(String parameterFormatType) {
        this.parameterFormatType = parameterFormatType;
    }

    public String getAddressingFormatType() {
        return addressingFormatType;
    }

    public void setAddressingFormatType(String addressingFormatType) {
        this.addressingFormatType = addressingFormatType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPortNo() {
        return portNo;
    }

    public void setPortNo(String portNo) {
        this.portNo = portNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHttpAuthenticationMethod() {
        return httpAuthenticationMethod;
    }

    public void setHttpAuthenticationMethod(String httpAuthenticationMethod) {
        this.httpAuthenticationMethod = httpAuthenticationMethod;
    }
}
