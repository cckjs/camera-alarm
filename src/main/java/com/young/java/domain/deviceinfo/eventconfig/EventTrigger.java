package com.young.java.domain.deviceinfo.eventconfig;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by Administrator on 2016/1/2.
 */
@XStreamAlias("EventTrigger")
public class EventTrigger {
    @XStreamAsAttribute
    private String version;
    @XStreamAsAttribute
    private String xmlns;

    private String id;

    private String eventType;

    private String eventDescription;

    private String inputIOPortID;

    private String videoInputChannelID;

    private String dynVideoInputChannelID;

    public com.young.java.domain.deviceinfo.eventconfig.EventTriggerNotificationList getEventTriggerNotificationList() {
        return EventTriggerNotificationList;
    }

    public void setEventTriggerNotificationList(com.young.java.domain.deviceinfo.eventconfig.EventTriggerNotificationList eventTriggerNotificationList) {
        EventTriggerNotificationList = eventTriggerNotificationList;
    }

    @XStreamAlias("EventTriggerNotificationList")
    private EventTriggerNotificationList EventTriggerNotificationList;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getInputIOPortID() {
        return inputIOPortID;
    }

    public void setInputIOPortID(String inputIOPortID) {
        this.inputIOPortID = inputIOPortID;
    }

    public String getVideoInputChannelID() {
        return videoInputChannelID;
    }

    public void setVideoInputChannelID(String videoInputChannelID) {
        this.videoInputChannelID = videoInputChannelID;
    }

    public String getDynVideoInputChannelID() {
        return dynVideoInputChannelID;
    }

    public void setDynVideoInputChannelID(String dynVideoInputChannelID) {
        this.dynVideoInputChannelID = dynVideoInputChannelID;
    }
}
