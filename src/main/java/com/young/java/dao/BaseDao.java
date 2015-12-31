package com.young.java.dao;

import com.young.java.util.PropertiesTool;

/**
 * Created by dell on 2015/12/31.
 */
public class BaseDao {
    protected PropertiesTool config = new PropertiesTool("config/system");

    protected String baseUrl = config.getStringValue("isapi_prefix");
}
