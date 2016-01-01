package com.young.java.domain.deviceinfo.system;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by Administrator on 2016/1/2.
 */
@XStreamAlias("system")
public class SystemConfig {
    @XStreamImplicit(itemFieldName = "systemInfo")
    private List<SystemConfigInfo> systemConfig;

    public List<SystemConfigInfo> getSystemConfig() {
        return systemConfig;
    }

    public void setSystemConfig(List<SystemConfigInfo> systemConfig) {
        this.systemConfig = systemConfig;
    }
}
