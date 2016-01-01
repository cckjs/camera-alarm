package com.young.camara.xml;


import com.young.java.domain.deviceinfo.ioinput.DeviceIOInputPort;
import com.young.java.domain.deviceinfo.ioinput.DeviceIOInputPortList;
import com.young.java.util.xml.XMLUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/1.
 */
public class DeviceIOInputPortListTest {

    private static XMLUtils xml = new XMLUtils(new Class[]{DeviceIOInputPort.class,DeviceIOInputPortList.class});

    public static void main(String[] args){
        DeviceIOInputPortList list = new DeviceIOInputPortList();
        List<DeviceIOInputPort> ports = new ArrayList<DeviceIOInputPort>();
        for (int i = 0; i < 10; i++) {
            ports.add(new DeviceIOInputPort());
        }
        String string = xml.toXml(list);
        System.out.println(string);
    }
}
