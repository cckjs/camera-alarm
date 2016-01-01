package com.young.java.dao;

import com.young.java.domain.deviceinfo.DeviceInfo;
import com.young.java.domain.deviceinfo.ioinput.DeviceIOInputPortList;
import com.young.java.domain.deviceinfo.iooutput.DeviceIOOutputPortList;
import com.young.java.domain.deviceinfo.notification.HttpHostNotification;
import com.young.java.util.http.HttpClientUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by dell on 2015/12/31.
 */
@Repository
public class AlarmDao extends BaseDao {

    public DeviceInfo getDeviceInfos() throws IOException {
        String url = baseUrl + "/ISAPI/System/deviceInfo";
        return getResources(url, DeviceInfo.class);
    }

    public DeviceIOInputPortList getDeviceIOInputPortList() throws IOException {
        String url = baseUrl + "/ISAPI/System/IO/inputs";
        return getResources(url, DeviceIOInputPortList.class);
    }

    public DeviceIOOutputPortList getDeviceIOOutputPortList() throws IOException {
        String url = baseUrl + "/ISAPI/System/IO/outputs";
        return getResources(url, DeviceIOOutputPortList.class);
    }

    public void setEventConfig(String enventId) throws IOException {
        String url = baseUrl + "/ISAPI/Event/triggers/" + enventId;
        HttpClientUtils.put(url, null, null, getAuth());
    }

    public void setNotificationConfig(HttpHostNotification notificationConfig) throws IOException {
        String url = baseUrl + "/ISAPI/Event/notification/httpHosts/"+ config.getStringValue("http_notification_id");
        HttpClientUtils.put(url,null,xml.toXml(notificationConfig),getAuth());
    }


}
