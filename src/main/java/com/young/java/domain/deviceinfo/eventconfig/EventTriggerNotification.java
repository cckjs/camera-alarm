package com.young.java.domain.deviceinfo.eventconfig;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2016/1/2.
 */
@XStreamAlias("EventTriggerNotification")
public class EventTriggerNotification {
    private String id;

    private String notificationMethod;

    private String notificationRecurrence;

    private String outputIOPortID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotificationMethod() {
        return notificationMethod;
    }

    public void setNotificationMethod(String notificationMethod) {
        this.notificationMethod = notificationMethod;
    }

    public String getNotificationRecurrence() {
        return notificationRecurrence;
    }

    public void setNotificationRecurrence(String notificationRecurrence) {
        this.notificationRecurrence = notificationRecurrence;
    }

    public String getOutputIOPortID() {
        return outputIOPortID;
    }

    public void setOutputIOPortID(String outputIOPortID) {
        this.outputIOPortID = outputIOPortID;
    }
}
