package com.young.java.domain.deviceinfo.iooutput;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2016/1/1.
 */
@XStreamAlias("IOOutputPort")
public class DeviceIOOutputPort {

    private String id;

    private DeviceIOOutputPortPowerOnState PowerOnState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DeviceIOOutputPortPowerOnState getPowerOnState() {
        return PowerOnState;
    }

    public void setPowerOnState(DeviceIOOutputPortPowerOnState powerOnState) {
        PowerOnState = powerOnState;
    }
}
