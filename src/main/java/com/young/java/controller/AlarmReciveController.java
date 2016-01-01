package com.young.java.controller;

import com.young.java.dao.AlarmDao;
import com.young.java.domain.deviceinfo.notification.EventNotificationAlert;
import com.young.java.domain.deviceinfo.notification.HttpHostNotification;
import com.young.java.util.json.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by Administrator on 2016/1/1.
 */
@Controller
@RequestMapping("/alarm")
@ResponseBody
public class AlarmReciveController {
    @Autowired
    private AlarmDao alarmDao;

    @RequestMapping(method = RequestMethod.POST)
    public void receiveAlarm(EventNotificationAlert alarm) throws IOException {
        System.out.println(JsonUtils.toJson(alarm));
    }
    @RequestMapping(value="/start",method = RequestMethod.GET)
    public void startAlarmConfig() throws IOException {
        configEvent();
        configNotifications();
    }

    private void configNotifications() throws IOException {
        HttpHostNotification notification = new HttpHostNotification();
        notification.setAddressingFormatType("ipaddress");
        notification.setHttpAuthenticationMethod("base64");
        notification.setId(alarmDao.getConfig().getStringValue("http_notification_id"));
        notification.setIpAddress(alarmDao.getConfig().getStringValue("http_notification_ip"));
        notification.setParameterFormatType("XML");
        notification.setPassword("password");
        notification.setPortNo(alarmDao.getConfig().getStringValue("http_notification_port"));
        notification.setProtocolType("HTTP");
        notification.setUrl(alarmDao.getConfig().getStringValue("http_notification_url"));
        notification.setUserName("user");
        notification.setVersion("2.0");
        notification.setXmlns("http://www.isapi.org/ver20/XMLSchema");
        alarmDao.setNotificationConfig(notification);
    }

    private void configEvent() {

    }
}
