package com.young.java.util.http;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/30.
 */
public class HttpClientUtils {

	private ContentType type;

	public HttpClientUtils(ContentType type) {
		this.type = type;
		httpClient = HttpClients.createDefault();
	}

	private HttpClient httpClient;

	public Response get(String url, String auth) throws IOException {
		HttpGet get = new HttpGet(url);
		get.setConfig(getHttpConfig());
		return sendRequest(get, null, auth);
	}

	public Response post(String url, Map<String, String> header, String content, String auth) throws IOException {
		HttpPost post = new HttpPost(url);
		post.setEntity(createContentEntity(content));
		post.setConfig(getHttpConfig());
		return sendRequest(post, header, auth);
	}

	public Response put(String url, Map<String, String> header, String content, String auth) throws IOException {
		HttpPut put = new HttpPut(url);
		put.setEntity(createContentEntity(content));
		put.setConfig(getHttpConfig());
		return sendRequest(put, header, auth);
	}

	public Response delete(String url, String auth) throws IOException {
		HttpDelete delete = new HttpDelete();
		delete.setConfig(getHttpConfig());
		return sendRequest(delete, null, auth);
	}

	private HttpEntity createContentEntity(String content) throws UnsupportedEncodingException {
		if (StringUtils.isBlank(content)) {
			return null;
		}
		StringEntity entity = new StringEntity(content, type);
		return entity;
	}

	private RequestConfig getHttpConfig() {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(3 * 1000).setSocketTimeout(5 * 1000)
				.setConnectTimeout(5 * 1000).build();
		return config;
	}

	private Response sendRequest(HttpUriRequest request, Map<String, String> params, String auth) throws IOException {
		request.addHeader("Authorization", auth);
		if (params != null) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				request.addHeader(entry.getKey(), entry.getValue());
			}
		}
		HttpResponse res = httpClient.execute(request);
		Response response = new Response();
		response.setCode(res.getStatusLine().getStatusCode());
		response.setMessage(res.getStatusLine().getReasonPhrase());
		response.setContent(IOUtils.toString(res.getEntity().getContent()));
		return response;
	}
}
