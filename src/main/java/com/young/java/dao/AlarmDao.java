package com.young.java.dao;

import com.young.java.domain.deviceinfo.DeviceInfo;
import com.young.java.domain.deviceinfo.eventconfig.EventTrigger;
import com.young.java.domain.deviceinfo.eventconfig.EventTriggerNotification;
import com.young.java.domain.deviceinfo.eventconfig.EventTriggerNotificationList;
import com.young.java.domain.deviceinfo.ioinput.DeviceIOInputPort;
import com.young.java.domain.deviceinfo.ioinput.DeviceIOInputPortList;
import com.young.java.domain.deviceinfo.iooutput.DeviceIOOutputPortList;
import com.young.java.domain.deviceinfo.notification.EventNotificationAlert;
import com.young.java.domain.deviceinfo.notification.HttpHostNotification;
import com.young.java.domain.deviceinfo.system.SystemConfig;
import com.young.java.domain.deviceinfo.system.SystemConfigInfo;
import com.young.java.util.http.HttpClientUtils;
import com.young.java.util.json.JsonUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2015/12/31.
 */
@Repository
public class AlarmDao extends BaseDao {

    public DeviceInfo getDeviceInfos(SystemConfigInfo configInfo) throws IOException {
        String url = configInfo.getIsapi().getIsapiPrefix() + "/ISAPI/System/deviceInfo";
        String auth = getAuth(configInfo.getIsapi());
        return getResources(url, DeviceInfo.class,auth);
    }

    public DeviceIOInputPortList getDeviceIOInputPortList(SystemConfigInfo configInfo) throws IOException {
        String url = configInfo.getIsapi().getIsapiPrefix() + "/ISAPI/System/IO/inputs";
        String auth = getAuth(configInfo.getIsapi());
        return getResources(url, DeviceIOInputPortList.class,auth);
    }

    public DeviceIOOutputPortList getDeviceIOOutputPortList(SystemConfigInfo configInfo) throws IOException {
        String url = configInfo.getIsapi().getIsapiPrefix() + "/ISAPI/System/IO/outputs";
        String auth = getAuth(configInfo.getIsapi());
        return getResources(url, DeviceIOOutputPortList.class,auth);
    }

    public void setIOInputPortEventConfig(SystemConfigInfo configInfo,DeviceIOInputPort inputPort) throws IOException {
        String url = configInfo.getIsapi().getIsapiPrefix() + "/ISAPI/Event/triggers/IO-" + inputPort.getId();
        EventTrigger eventTrigger = getEventTrigger(inputPort);
        String auth = getAuth(configInfo.getIsapi());
        HttpClientUtils.put(url,null,xml.toXml(eventTrigger),auth);
    }

    private EventTrigger getEventTrigger(DeviceIOInputPort inputPort) {
        EventTrigger eventTrigger = new EventTrigger();
        eventTrigger.setVersion("2.0");
        eventTrigger.setXmlns("http://www.isapi.org/ver20/XMLSchema");
        eventTrigger.setDynVideoInputChannelID(inputPort.getId());
        eventTrigger.setEventDescription("IO Event trigger Information");
        eventTrigger.setEventType("IO");
        eventTrigger.setId("IO-" + inputPort.getId());
        eventTrigger.setInputIOPortID(inputPort.getId());
        eventTrigger.setVideoInputChannelID(inputPort.getId());
        EventTriggerNotificationList list = new EventTriggerNotificationList();
        list.setVersion("2.0");
        list.setXmlns("http://www.isapi.org/ver20/XMLSchema");
        List<EventTriggerNotification> notifications = new ArrayList<EventTriggerNotification>();
        EventTriggerNotification notification = new EventTriggerNotification();
        notification.setId("IO-" + inputPort.getId());
        notification.setNotificationMethod("HTTP");
        notification.setNotificationRecurrence("beginning");
        notifications.add(notification);
        list.setLists(notifications);
        eventTrigger.setEventTriggerNotificationList(list);
        return eventTrigger;

    }

    public void setNotificationConfig(SystemConfigInfo configInfo,HttpHostNotification notificationConfig) throws IOException {
        String url = configInfo.getIsapi().getIsapiPrefix() + "/ISAPI/Event/notification/httpHosts/" + configInfo.getAlarmCenter().getHttpNotificationId();
        String auth = getAuth(configInfo.getIsapi());
        HttpClientUtils.put(url, null, xml.toXml(notificationConfig), auth);
    }

    public SystemConfig getSystemConfig(InputStream input) throws IOException {
        String xmlString = IOUtils.toString(input,"utf-8");
        return xml.fromXml(xmlString,SystemConfig.class);
    }

    public void pushAlarm(EventNotificationAlert alarm,String pushUrl) throws IOException {
        HttpClientUtils.post(pushUrl,null, JsonUtils.toJson(alarm),"");
    }
}
