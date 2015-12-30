package com.young.java.util;

import com.thoughtworks.xstream.XStream;

/**
 * Created by dell on 2015/12/30.
 */
public class XMLUtils {

    private XStream stream;

    public XMLUtils(Class[] classes){
        stream = new XStream();
        stream.autodetectAnnotations(true);
        stream.processAnnotations(classes);
    }

    public String toXml(Object obj){
       return stream.toXML(obj);
    }

    public <T> T fromXml(String xml,Class<T> clazz){
        return (T)stream.fromXml(xml);
    }
}
