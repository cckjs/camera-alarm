package com.young.java.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by dell on 2015/12/31.
 */
public class PropertiesTool {

    private ResourceBundle config;

    public PropertiesTool(String configPath){
        config = ResourceBundle.getBundle(configPath, Locale.getDefault());
    }

    public String getStringValue(String key){
        return config.getString(key);
    }

    public Object getObjectValue(String key){
        return config.getObject(key);
    }
}
