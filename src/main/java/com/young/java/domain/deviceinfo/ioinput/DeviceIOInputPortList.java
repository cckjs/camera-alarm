package com.young.java.domain.deviceinfo.ioinput;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by Administrator on 2015/12/31.
 */
@XStreamAlias("IOInputPortList")
public class DeviceIOInputPortList {
    @XStreamImplicit(itemFieldName = "IOInputPort")
    private List<DeviceIOInputPort> IOInputPortList;

    public List<DeviceIOInputPort> getIOInputPortList() {
        return IOInputPortList;
    }

    public void setIOInputPortList(List<DeviceIOInputPort> IOInputPortList) {
        this.IOInputPortList = IOInputPortList;
    }
}
