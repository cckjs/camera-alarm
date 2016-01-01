package com.young.java.domain.deviceinfo.iooutput;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by Administrator on 2016/1/1.
 */
@XStreamAlias("IOOutputPortList")
public class DeviceIOOutputPortList {
    @XStreamImplicit(itemFieldName = "IOOutputPortList")
    private List<DeviceIOOutputPort> IOOutputPortList;

    public List<DeviceIOOutputPort> getIOOutputPortList() {
        return IOOutputPortList;
    }

    public void setIOOutputPortList(List<DeviceIOOutputPort> IOOutputPortList) {
        this.IOOutputPortList = IOOutputPortList;
    }
}
