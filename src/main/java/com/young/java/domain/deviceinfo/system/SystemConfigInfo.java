package com.young.java.domain.deviceinfo.system;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2016/1/2.
 */
@XStreamAlias("systemInfo")
public class SystemConfigInfo {
    private ISAPIConfig isapi;

    private AlarmCenterInfo alarmCenter;

    public ISAPIConfig getIsapi() {
        return isapi;
    }

    public void setIsapi(ISAPIConfig isapi) {
        this.isapi = isapi;
    }

    public AlarmCenterInfo getAlarmCenter() {
        return alarmCenter;
    }

    public void setAlarmCenter(AlarmCenterInfo alarmCenter) {
        this.alarmCenter = alarmCenter;
    }

    public PlatformInfo getPlatForm() {
        return platForm;
    }

    public void setPlatForm(PlatformInfo platForm) {
        this.platForm = platForm;
    }

    private PlatformInfo platForm;
}
