package com.young.java.domain.deviceinfo.ioinput;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2015/12/31.
 */
@XStreamAlias("IOInputPort")
public class DeviceIOInputPort {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTriggering() {
        return triggering;
    }

    public void setTriggering(String triggering) {
        this.triggering = triggering;
    }

    private String id;
    private String triggering;
}
