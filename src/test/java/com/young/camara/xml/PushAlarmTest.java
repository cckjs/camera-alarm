package com.young.camara.xml;

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
import com.young.java.util.http.HttpClientUtils;
import com.young.java.util.xml.XMLUtils;
import org.apache.http.entity.ContentType;

import java.io.IOException;

/**
 * Created by Administrator on 2016/1/2.
 */
public class PushAlarmTest {

    protected static XMLUtils xml = new XMLUtils(new Class[]{EventTrigger.class, EventTriggerNotification.class,
            EventTriggerNotificationList.class, DeviceIOInputPort.class, DeviceIOInputPortList.class,
            DeviceIOOutputPort.class, DeviceIOOutputPortList.class, DeviceIOOutputPortPowerOnState.class,
            EventNotificationAlert.class, HttpHostNotification.class, AlarmCenterInfo.class,ISAPIConfig.class,
            PlatformInfo.class, SystemConfig.class, SystemConfigInfo.class, DeviceInfo.class});

    public static void main(String[] args) throws IOException {
        HttpClientUtils client = new HttpClientUtils(ContentType.create("application/xml", "utf-8"));
        EventNotificationAlert alert = new EventNotificationAlert();
        alert.setActivePostCount("");
        alert.setChannelID("1");
        alert.setDateTime("2012-05-27T16:58:33");
        alert.setEventDescription("motion detection alarm");
        alert.setEventState("active");
        alert.setEventType("VMD");
        alert.setIpAddress("172.8.6.175");
        alert.setMacAddress("00:40:48:64:10:fa");
        alert.setProtocolType("HTTP");
        alert.setVersion("2.0");
        alert.setXmlns("http://www.isapi.org/ver20/XMLSchema");

        client.post("http://localhost:8080/camera-alarm/alarm",null,xml.toXml(alert),"");
    }
}
