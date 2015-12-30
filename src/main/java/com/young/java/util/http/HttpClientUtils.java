package com.young.java.util.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/30.
 */
public class HttpClientUtils {
    private static HttpClient httpClient = HttpClients.createDefault();

    public static Response get(String url, String auth) throws IOException {
        HttpGet get = new HttpGet(url);
        get.setConfig(getHttpConfig());
        return sendRequest(get, auth);
    }

    public static Response post(String url, Map<String, String> params, String content, String auth) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setEntity(getParameterEntity(params));
        post.setConfig(getHttpConfig());
        return sendRequest(post, auth);
    }

    public static Response put(String url, Map<String, String> params, String content, String auth) throws IOException {
        HttpPut put = new HttpPut(url);
        put.setEntity(getParameterEntity(params));
        put.setConfig(getHttpConfig());
        return sendRequest(put,auth);
    }

    public static Response delete(String url,String auth) throws IOException {
        HttpDelete delete = new HttpDelete();
        delete.setConfig(getHttpConfig());
        return sendRequest(delete,auth);
    }
    private static HttpEntity getParameterEntity(Map<String, String> parameters)
            throws UnsupportedEncodingException {
        if (parameters == null || parameters.size() == 0) {
            return null;
        }
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
        return entity;
    }

    private static RequestConfig getHttpConfig() {
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(3 * 1000)
                .setSocketTimeout(5 * 1000).setConnectTimeout(5 * 1000).build();
        return config;
    }

    private static Response sendRequest(HttpUriRequest request, String auth) throws IOException {
        HttpResponse res = httpClient.execute(request);
        request.addHeader("Authorization", auth);
        Response response = new Response();
        response.setCode(res.getStatusLine().getStatusCode());
        response.setMessage(res.getStatusLine().getReasonPhrase());
        response.setContent(IOUtils.toString(res.getEntity().getContent()));
        return response;
    }
}
