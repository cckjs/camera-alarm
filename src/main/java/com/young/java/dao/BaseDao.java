package com.young.java.dao;

import com.young.java.util.PropertiesTool;
import com.young.java.util.base64.Base64Tool;
import com.young.java.util.http.HttpClientUtils;
import com.young.java.util.http.Response;
import com.young.java.util.xml.XMLUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by dell on 2015/12/31.
 */
public class BaseDao {
    protected PropertiesTool config = new PropertiesTool("config/system");

    protected String baseUrl = config.getStringValue("isapi_prefix");

    protected String isapi_user = config.getStringValue("isapi_user");

    protected String isapi_password = config.getStringValue("isapi_password");

    protected XMLUtils xml = new XMLUtils(new Class[]{Map.class});

    protected String getAuth(){
        return "Basic "+ Base64Tool.encode(isapi_user+":"+isapi_password);
    }

    protected  <T> T getResources(String resourceUrl,Class<T> tClass) throws IOException {
        Response res = HttpClientUtils.get(resourceUrl, getAuth());
        return xml.fromXml(res.getContent(),tClass);
    }

    public PropertiesTool getConfig(){
        return config;
    }
}
