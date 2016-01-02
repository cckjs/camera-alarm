package com.young.java.controller;

import com.young.java.dao.AlarmDao;
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
import com.young.java.domain.deviceinfo.system.AlarmCenterInfo;
import com.young.java.domain.deviceinfo.system.ISAPIConfig;
import com.young.java.domain.deviceinfo.system.PlatformInfo;
import com.young.java.domain.deviceinfo.system.SystemConfig;
import com.young.java.domain.deviceinfo.system.SystemConfigInfo;
import com.young.java.util.json.JsonUtils;
import com.young.java.util.xml.XMLUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/1/1.
 */
@Controller
@RequestMapping("/alarm")
@ResponseBody
public class AlarmReciveController {
	@Autowired
	private AlarmDao alarmDao;

	private SystemConfig systemConfig;

	protected XMLUtils xml = new XMLUtils(new Class[] { EventTrigger.class, EventTriggerNotification.class,
			EventTriggerNotificationList.class, DeviceIOInputPort.class, DeviceIOInputPortList.class,
			DeviceIOOutputPort.class, DeviceIOOutputPortList.class, DeviceIOOutputPortPowerOnState.class,
			EventNotificationAlert.class, HttpHostNotification.class, AlarmCenterInfo.class, ISAPIConfig.class,
			PlatformInfo.class, SystemConfig.class, SystemConfigInfo.class, DeviceInfo.class });

	private SystemConfig getSystemConfig() throws FileNotFoundException, IOException{
		if (systemConfig == null) {
			String path = AlarmReciveController.class.getResource("/").getPath() + File.separator + "system.xml";
			systemConfig = alarmDao.getSystemConfig(new FileInputStream(path));
		}
		return systemConfig;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void receiveAlarm(HttpServletRequest request) throws IOException {
		EventNotificationAlert alarm = xml.fromXml(request.getInputStream(), EventNotificationAlert.class);
		System.out.println(JsonUtils.toJson(alarm));
		if (getSystemConfig() != null && !CollectionUtils.isEmpty(getSystemConfig().getSystemConfig())) {
			for (SystemConfigInfo configInfo : getSystemConfig().getSystemConfig()) {
				if (configInfo.getPlatForm() != null
						&& !CollectionUtils.isEmpty(configInfo.getPlatForm().getPushUrl())) {
					for (String pushUrl : configInfo.getPlatForm().getPushUrl()) {
						alarmDao.pushAlarm(alarm, pushUrl, configInfo.getPlatForm().getContentType(),
								getPlatformAuth(configInfo));
					}
				}
			}
		}
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public void testReceive(HttpServletRequest request) throws IOException {
		EventNotificationAlert alarm = xml.fromXml(request.getInputStream(), EventNotificationAlert.class);
		System.out.println(JsonUtils.toJson(alarm));
	}

	private String getPlatformAuth(SystemConfigInfo configInfo) {
		return "";
	}

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public void startAlarmConfig() throws IOException {
		
		if (getSystemConfig() != null && !CollectionUtils.isEmpty(getSystemConfig().getSystemConfig())) {
			for (SystemConfigInfo configInfo : getSystemConfig().getSystemConfig()) {
				configEvent(configInfo);
				configNotifications(configInfo);
			}
		}
	}

	private void configNotifications(SystemConfigInfo configInfo) throws IOException {
		HttpHostNotification notification = new HttpHostNotification();
		notification.setAddressingFormatType("ipaddress");
		notification.setHttpAuthenticationMethod("base64");
		notification.setId(configInfo.getAlarmCenter().getHttpNotificationId());
		notification.setIpAddress(configInfo.getAlarmCenter().getHttpNotificationIp());
		notification.setParameterFormatType("XML");
		notification.setPassword("password");
		notification.setPortNo(configInfo.getAlarmCenter().getHttpNotificationPort());
		notification.setProtocolType("HTTP");
		notification.setUrl(configInfo.getAlarmCenter().getHttpNotificationUrl());
		notification.setUserName("user");
		notification.setVersion("2.0");
		notification.setXmlns("http://www.isapi.org/ver20/XMLSchema");
		alarmDao.setNotificationConfig(configInfo, notification);
	}

	private void configEvent(SystemConfigInfo configInfo) throws IOException {
		DeviceIOInputPortList inputList = alarmDao.getDeviceIOInputPortList(configInfo);
		if (!CollectionUtils.isEmpty(inputList.getIOInputPortList())) {
			for (DeviceIOInputPort inputPort : inputList.getIOInputPortList()) {
				alarmDao.setIOInputPortEventConfig(configInfo, inputPort);
			}
		}
	}

}
