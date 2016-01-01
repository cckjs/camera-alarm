package com.young.java.dao;

import com.young.java.domain.deviceinfo.DeviceInfo;
import com.young.java.domain.deviceinfo.eventconfig.EventTrigger;
import com.young.java.domain.deviceinfo.eventconfig.EventTriggerNotification;
import com.young.java.domain.deviceinfo.eventconfig.EventTriggerNotificationList;
import com.young.java.domain.deviceinfo.ioinput.DeviceIOInputPort;
import com.young.java.domain.deviceinfo.ioinput.DeviceIOInputPortList;
import com.young.java.domain.deviceinfo.iooutput.DeviceIOOutputPort;
import com.young.java.domain.deviceinfo.iooutput.DeviceIOOutputPortList;
import com.young.java.domain.deviceinfo.iooutput.DeviceIOOutputPortPowerOnState;
import com.young.java.domain.deviceinfo.notification.EventNotificationAlert;
import com.young.java.domain.deviceinfo.notification.HttpHostNotification;
import com.young.java.domain.deviceinfo.system.*;
import com.young.java.util.base64.Base64Tool;
import com.young.java.util.http.HttpClientUtils;
import com.young.java.util.http.Response;
import com.young.java.util.xml.XMLUtils;

import java.io.IOException;

/**
 * Created by dell on 2015/12/31.
 */
public class BaseDao {

    protected XMLUtils xml = new XMLUtils(new Class[]{EventTrigger.class, EventTriggerNotification.class,
            EventTriggerNotificationList.class, DeviceIOInputPort.class, DeviceIOInputPortList.class,
            DeviceIOOutputPort.class, DeviceIOOutputPortList.class, DeviceIOOutputPortPowerOnState.class,
            EventNotificationAlert.class, HttpHostNotification.class, AlarmCenterInfo.class,ISAPIConfig.class,
            PlatformInfo.class, SystemConfig.class, SystemConfigInfo.class, DeviceInfo.class});

    protected String getAuth(ISAPIConfig ISAPI){
        return "Basic "+ Base64Tool.encode(ISAPI.getIsapiUser()+":"+ISAPI.getIsapiPassword());
    }

    protected  <T> T getResources(String resourceUrl,Class<T> tClass,String auth) throws IOException {
        Response res = HttpClientUtils.get(resourceUrl, auth);
        return xml.fromXml(res.getContent(),tClass);
    }

}
