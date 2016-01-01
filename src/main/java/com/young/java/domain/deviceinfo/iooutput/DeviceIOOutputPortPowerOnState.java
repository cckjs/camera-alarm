package com.young.java.domain.deviceinfo.iooutput;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2016/1/1.
 */
@XStreamAlias("PowerOnState")
public class DeviceIOOutputPortPowerOnState {
    private String defaultState;

    public String getDefaultState() {
        return defaultState;
    }

    public void setDefaultState(String defaultState) {
        this.defaultState = defaultState;
    }

    public String getOutputState() {
        return outputState;
    }

    public void setOutputState(String outputState) {
        this.outputState = outputState;
    }

    public String getPulseDuration() {
        return pulseDuration;
    }

    public void setPulseDuration(String pulseDuration) {
        this.pulseDuration = pulseDuration;
    }

    private String outputState;
    private String pulseDuration;
}
