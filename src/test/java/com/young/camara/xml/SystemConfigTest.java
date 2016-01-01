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
import com.young.java.util.xml.XMLUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/2.
 */
public class SystemConfigTest {

    protected static XMLUtils xml = new XMLUtils(new Class[]{EventTrigger.class, EventTriggerNotification.class,
            EventTriggerNotificationList.class, DeviceIOInputPort.class, DeviceIOInputPortList.class,
            DeviceIOOutputPort.class, DeviceIOOutputPortList.class, DeviceIOOutputPortPowerOnState.class,
            EventNotificationAlert.class, HttpHostNotification.class, AlarmCenterInfo.class,ISAPIConfig.class,
            PlatformInfo.class, SystemConfig.class, SystemConfigInfo.class, DeviceInfo.class});

    public static void createSystemConfig() throws IOException {
        SystemConfig systemConfig = new SystemConfig();
        List<SystemConfigInfo> configInfoList = new ArrayList<SystemConfigInfo>();
        SystemConfigInfo configInfo = new SystemConfigInfo();
        ISAPIConfig ISAPI = new ISAPIConfig();
        ISAPI.setIsapiPassword("anft123456ANFT");
        ISAPI.setIsapiUser("admin");
        ISAPI.setIsapiPrefix("http://192.168.1.106");

        AlarmCenterInfo alarmCenterInfo = new AlarmCenterInfo();
        alarmCenterInfo.setHttpNotificationId("1");
        alarmCenterInfo.setHttpNotificationIp("localhost");
        alarmCenterInfo.setHttpNotificationPort("8080");
        alarmCenterInfo.setHttpNotificationUrl("/camera-alarm/alarm");

        PlatformInfo platformInfo = new PlatformInfo();
        List<String> pushUrl = new ArrayList<String>();
        pushUrl.add("http://localhost:8080/test");
        platformInfo.setPushUrl(pushUrl);
        configInfo.setAlarmCenter(alarmCenterInfo);
        configInfo.setIsapi(ISAPI);
        configInfo.setPlatForm(platformInfo);
        configInfoList.add(configInfo);

        systemConfig.setSystemConfig(configInfoList);

        String xmlString = xml.toXml(systemConfig);
        FileUtils.writeStringToFile(new File("E:\\data\\system.xml"),xmlString,"utf-8");
    }

    public static void readSystemConfig() throws IOException {
       // String path = SystemConfigTest.class.getResource("/").getPath()+File.separator+"system.xml";
        String path = "e:\\data\\system.xml";
        String xmlString = IOUtils.toString(new FileInputStream(path),"utf-8");
        SystemConfig config = xml.fromXml(xmlString,SystemConfig.class);
        System.out.println(config.getSystemConfig().size());
    }

    public static void main(String[] args) throws IOException {
      readSystemConfig();

    }
}
