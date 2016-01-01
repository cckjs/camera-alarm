package com.young.java.domain.deviceinfo.eventconfig;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by Administrator on 2016/1/2.
 */
@XStreamAlias("EventTriggerNotificationList")
public class EventTriggerNotificationList {

    @XStreamAsAttribute
    private String version;
    @XStreamAsAttribute
    private String xmlns;


    @XStreamImplicit(itemFieldName = "EventTriggerNotification")
    private List<EventTriggerNotification> lists;

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

    public List<EventTriggerNotification> getLists() {
        return lists;
    }

    public void setLists(List<EventTriggerNotification> lists) {
        this.lists = lists;
    }
}
